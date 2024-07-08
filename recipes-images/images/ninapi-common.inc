SYSTEMD_DEFAULT_TARGET = "custom-elk.target"

IMAGE_LINGUAS += "en-us"

IMAGE_INSTALL += "\
    packagegroup-elk-applications \
    packagegroup-elk-libs-basic \
    packagegroup-nina-system-basic \
    packagegroup-elk-raspberrypi-system-pkgs \
    packagegroup-elkpi-apps-basic \
    packagegroup-elkpi-system-basic-pkgs \
    packagegroup-elk-python-basic \
"

IMAGE_INSTALL_remove = " dropbear"

TOOLCHAIN_HOST_TASK += "\
    nativesdk-grpc \
    nativesdk-grpc-dev \
"

# Set permissions for nina user for home/nina
set_special_permissions () {
    chown -R nina ${IMAGE_ROOTFS}/home/nina
    chgrp -R nina ${IMAGE_ROOTFS}/home/nina
}

ROOTFS_POSTPROCESS_COMMAND += "set_special_permissions; "

# Function which prerares the dual rootfs and udata partitions for the final image
do_wic_image_prepare() {
    sed -i 's/console=serial0,115200/console=${SERIAL_CONSOLES}/' ${DEPLOY_DIR_IMAGE}/${BOOTFILES_DIR_NAME}/cmdline.txt
    wic cp ${DEPLOY_DIR_IMAGE}/${BOOTFILES_DIR_NAME}/cmdline.txt ${DEPLOY_DIR_IMAGE}/${DISTRO}-firmware-${SWU_VERSION}.wic:1
    #change perm on first boot service condition file in udata
    echo "change_perms" > ${DEPLOY_DIR_IMAGE}/change_perms
    wic cp ${DEPLOY_DIR_IMAGE}/change_perms ${DEPLOY_DIR_IMAGE}/${DISTRO}-firmware-${SWU_VERSION}.wic:4
    rm -f ${DEPLOY_DIR_IMAGE}/change_perms

    #setup nina
    wic cp ${DEPLOY_DIR_IMAGE}/config.json ${DEPLOY_DIR_IMAGE}/${DISTRO}-firmware-${SWU_VERSION}.wic:4
    rm -f ${DEPLOY_DIR_IMAGE}/config.json
    wic cp ${DEPLOY_DIR_IMAGE}/global_params.json ${DEPLOY_DIR_IMAGE}/${DISTRO}-firmware-${SWU_VERSION}.wic:4
    rm -f ${DEPLOY_DIR_IMAGE}/global_params.json
    wic cp ${DEPLOY_DIR_IMAGE}/001_TEST_VCO_1_TRI.json ${DEPLOY_DIR_IMAGE}/${DISTRO}-firmware-${SWU_VERSION}.wic:4
    rm -f ${DEPLOY_DIR_IMAGE}/001_TEST_VCO_1_TRI.json
    wic cp ${DEPLOY_DIR_IMAGE}/002_TEST_VCO_1_SQR.json ${DEPLOY_DIR_IMAGE}/${DISTRO}-firmware-${SWU_VERSION}.wic:4
    rm -f ${DEPLOY_DIR_IMAGE}/002_TEST_VCO_1_SQR.json
    wic cp ${DEPLOY_DIR_IMAGE}/003_TEST_VCO_2_TRI.json ${DEPLOY_DIR_IMAGE}/${DISTRO}-firmware-${SWU_VERSION}.wic:4
    rm -f ${DEPLOY_DIR_IMAGE}/003_TEST_VCO_2_TRI.json
    wic cp ${DEPLOY_DIR_IMAGE}/004_TEST_VCO_2_SQR.json ${DEPLOY_DIR_IMAGE}/${DISTRO}-firmware-${SWU_VERSION}.wic:4
    rm -f ${DEPLOY_DIR_IMAGE}/004_TEST_VCO_2_SQR.json
    wic cp ${DEPLOY_DIR_IMAGE}/005_TEST_VCO_2_SYNC.json ${DEPLOY_DIR_IMAGE}/${DISTRO}-firmware-${SWU_VERSION}.wic:4
    rm -f ${DEPLOY_DIR_IMAGE}/005_TEST_VCO_2_SYNC.json
    wic cp ${DEPLOY_DIR_IMAGE}/006_TEST_OSC_3.json ${DEPLOY_DIR_IMAGE}/${DISTRO}-firmware-${SWU_VERSION}.wic:4
    rm -f ${DEPLOY_DIR_IMAGE}/006_TEST_OSC_3.json
    wic cp ${DEPLOY_DIR_IMAGE}/007_VCF_SELF_CHIRP.json ${DEPLOY_DIR_IMAGE}/${DISTRO}-firmware-${SWU_VERSION}.wic:4
    rm -f ${DEPLOY_DIR_IMAGE}/007_VCF_SELF_CHIRP.json
    wic cp ${DEPLOY_DIR_IMAGE}/008_VCA_LEFT_RIGHT_SPIN.json ${DEPLOY_DIR_IMAGE}/${DISTRO}-firmware-${SWU_VERSION}.wic:4
    rm -f ${DEPLOY_DIR_IMAGE}/008_VCA_LEFT_RIGHT_SPIN.json
    wic cp ${DEPLOY_DIR_IMAGE}/009_TEST_FX.json ${DEPLOY_DIR_IMAGE}/${DISTRO}-firmware-${SWU_VERSION}.wic:4
    rm -f ${DEPLOY_DIR_IMAGE}/009_TEST_FX.json
    wic cp ${DEPLOY_DIR_IMAGE}/010_VOICE_SILENCE_TEST.json ${DEPLOY_DIR_IMAGE}/${DISTRO}-firmware-${SWU_VERSION}.wic:4
    rm -f ${DEPLOY_DIR_IMAGE}/010_VOICE_SILENCE_TEST.json
    wic cp ${DEPLOY_DIR_IMAGE}/011_TEST_PLAY.json ${DEPLOY_DIR_IMAGE}/${DISTRO}-firmware-${SWU_VERSION}.wic:4
    rm -f ${DEPLOY_DIR_IMAGE}/011_TEST_PLAY.json
    wic cp ${DEPLOY_DIR_IMAGE}/012_VCF_SELF_OSC.json ${DEPLOY_DIR_IMAGE}/${DISTRO}-firmware-${SWU_VERSION}.wic:4
    rm -f ${DEPLOY_DIR_IMAGE}/012_VCF_SELF_OSC.json
    wic cp ${DEPLOY_DIR_IMAGE}/013_TEST_ARP.json ${DEPLOY_DIR_IMAGE}/${DISTRO}-firmware-${SWU_VERSION}.wic:4
    rm -f ${DEPLOY_DIR_IMAGE}/013_TEST_ARP.json
    wic cp ${DEPLOY_DIR_IMAGE}/014_TEST_VCO_1_SUB.json ${DEPLOY_DIR_IMAGE}/${DISTRO}-firmware-${SWU_VERSION}.wic:4
    rm -f ${DEPLOY_DIR_IMAGE}/014_TEST_VCO_1_SUB.json
    wic cp ${DEPLOY_DIR_IMAGE}/015_TEST_ENCODERS.json ${DEPLOY_DIR_IMAGE}/${DISTRO}-firmware-${SWU_VERSION}.wic:4
    rm -f ${DEPLOY_DIR_IMAGE}/015_TEST_ENCODERS.json
    wic cp ${DEPLOY_DIR_IMAGE}/016_TEST_VCO_WIDTH.json ${DEPLOY_DIR_IMAGE}/${DISTRO}-firmware-${SWU_VERSION}.wic:4
    rm -f ${DEPLOY_DIR_IMAGE}/016_TEST_VCO_WIDTH.json
    wic cp ${DEPLOY_DIR_IMAGE}/017_TEST_TEMPLATE.json ${DEPLOY_DIR_IMAGE}/${DISTRO}-firmware-${SWU_VERSION}.wic:4
    rm -f ${DEPLOY_DIR_IMAGE}/017_TEST_TEMPLATE.json
    wic cp ${DEPLOY_DIR_IMAGE}/wavetables.tar.xz ${DEPLOY_DIR_IMAGE}/${DISTRO}-firmware-${SWU_VERSION}.wic:4
    rm -f ${DEPLOY_DIR_IMAGE}/wavetables.tar.xz

    wic ls ${DEPLOY_DIR_IMAGE}/${DISTRO}-firmware-${SWU_VERSION}.wic:4
    bzip2 -c ${DEPLOY_DIR_IMAGE}/${DISTRO}-firmware-${SWU_VERSION}.wic > ${DEPLOY_DIR_IMAGE}/${DISTRO}-firmware-${SWU_VERSION}.wic.bz2
}

addtask wic_image_prepare after do_image_complete before do_rm_work
