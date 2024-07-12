SUMMARY = "Config files and scripts for the NINA OS image"
HOMEPAGE = "https://github.com/Melbourne-Instruments/meta-ninapi"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "git://github.com/Melbourne-Instruments/configs.git \
           file://wavetables.tar.xz;unpack=0 \
           file://bin.zip \
           "
SRCREV = "e0ac1be55730ce121e1d64567a0eaa8720b9bbae"

do_install[nostamp] = "1"

ROOT_HOME_DIR = "/home/root"
NINA_HOME_DIR = "/home/nina"

do_install () {
    install -d ${D}${NINA_HOME_DIR}
    install -d ${D}${ROOT_HOME_DIR}
    install -d ${D}${ROOT_HOME_DIR}/nina
    install -d ${D}${ROOT_HOME_DIR}/nina/scripts
    cp ${WORKDIR}/git/nina/nina_ui/haptic_modes.json ${D}${ROOT_HOME_DIR}/nina
    cp ${WORKDIR}/git/nina/nina_ui/param_map.json ${D}${ROOT_HOME_DIR}/nina
    cp ${WORKDIR}/git/nina/nina_ui/param_attributes.json ${D}${ROOT_HOME_DIR}/nina
    cp ${WORKDIR}/git/nina/nina_ui/param_lists.json ${D}${ROOT_HOME_DIR}/nina
    cp ${WORKDIR}/git/nina/nina_ui/param_blacklist.json ${D}${ROOT_HOME_DIR}/nina
    cp ${WORKDIR}/git/nina/nina_ui/param_aliases.json ${D}${ROOT_HOME_DIR}/nina
    cp ${WORKDIR}/git/nina/nina_ui/system_colours.json ${D}${ROOT_HOME_DIR}/nina
    cp ${WORKDIR}/git/nina/nina_ui/ONE_LAYER.json ${D}${ROOT_HOME_DIR}/nina
    cp ${WORKDIR}/git/nina/nina_ui/BASIC_PATCH.json ${D}${ROOT_HOME_DIR}/nina
    cp ${WORKDIR}/git/nina/nina_ui/INIT_PATCH.json ${D}${ROOT_HOME_DIR}/nina
    cp ${WORKDIR}/git/nina/sushi/config_nina.json ${D}${ROOT_HOME_DIR}/nina
    cp ${WORKDIR}/git/nina/scripts/addBank.py ${D}${ROOT_HOME_DIR}/nina/scripts
    cp ${WORKDIR}/git/nina/scripts/backup.sh ${D}${ROOT_HOME_DIR}/nina/scripts
    cp ${WORKDIR}/git/nina/scripts/backupUserWt.py ${D}${ROOT_HOME_DIR}/nina/scripts
    cp ${WORKDIR}/git/nina/scripts/bank_add.sh ${D}${ROOT_HOME_DIR}/nina/scripts
    cp ${WORKDIR}/git/nina/scripts/bank_clear.sh ${D}${ROOT_HOME_DIR}/nina/scripts
    cp ${WORKDIR}/git/nina/scripts/bank_export.sh ${D}${ROOT_HOME_DIR}/nina/scripts
    cp ${WORKDIR}/git/nina/scripts/bank_import_merge.sh ${D}${ROOT_HOME_DIR}/nina/scripts
    cp ${WORKDIR}/git/nina/scripts/bank_import_merge_check.sh ${D}${ROOT_HOME_DIR}/nina/scripts
    cp ${WORKDIR}/git/nina/scripts/bank_import_overwrite.sh ${D}${ROOT_HOME_DIR}/nina/scripts
    cp ${WORKDIR}/git/nina/scripts/calibrate.sh ${D}${ROOT_HOME_DIR}/nina/scripts
    cp ${WORKDIR}/git/nina/scripts/deleteDuplicateBlanks.py ${D}${ROOT_HOME_DIR}/nina/scripts
    cp ${WORKDIR}/git/nina/scripts/factoryWtList.py ${D}${ROOT_HOME_DIR}/nina/scripts
    cp ${WORKDIR}/git/nina/scripts/factory_calibrate.sh ${D}${ROOT_HOME_DIR}/nina/scripts
    cp ${WORKDIR}/git/nina/scripts/i2c.py ${D}${ROOT_HOME_DIR}/nina/scripts
    cp ${WORKDIR}/git/nina/scripts/ledTest.py ${D}${ROOT_HOME_DIR}/nina/scripts
    cp ${WORKDIR}/git/nina/scripts/loadUserWt.py ${D}${ROOT_HOME_DIR}/nina/scripts
    cp ${WORKDIR}/git/nina/scripts/loadWt.sh ${D}${ROOT_HOME_DIR}/nina/scripts
    cp ${WORKDIR}/git/nina/scripts/log_temp.sh ${D}${ROOT_HOME_DIR}/nina/scripts
    cp ${WORKDIR}/git/nina/scripts/mergeBank.py ${D}${ROOT_HOME_DIR}/nina/scripts
    cp ${WORKDIR}/git/nina/scripts/mergePatches.py ${D}${ROOT_HOME_DIR}/nina/scripts
    cp ${WORKDIR}/git/nina/scripts/overwriteBank.py ${D}${ROOT_HOME_DIR}/nina/scripts
    cp ${WORKDIR}/git/nina/scripts/patchUpdate.py ${D}${ROOT_HOME_DIR}/nina/scripts
    cp ${WORKDIR}/git/nina/scripts/restore_backup.sh ${D}${ROOT_HOME_DIR}/nina/scripts
    cp ${WORKDIR}/git/nina/scripts/soakTest.py ${D}${ROOT_HOME_DIR}/nina/scripts
    cp ${WORKDIR}/git/nina/scripts/soakTestInterface.py ${D}${ROOT_HOME_DIR}/nina/scripts
    cp ${WORKDIR}/git/nina/scripts/wavfile.py ${D}${ROOT_HOME_DIR}/nina/scripts
    cp ${WORKDIR}/git/nina/scripts/wtExportBank.py ${D}${ROOT_HOME_DIR}/nina/scripts
    cp ${WORKDIR}/git/nina/scripts/wtPrune.py ${D}${ROOT_HOME_DIR}/nina/scripts
    cp ${WORKDIR}/git/nina/scripts/wt_export.sh ${D}${ROOT_HOME_DIR}/nina/scripts
    cp ${WORKDIR}/git/nina/scripts/wt_import.sh ${D}${ROOT_HOME_DIR}/nina/scripts
    cp ${WORKDIR}/git/nina/scripts/wt_prune.sh ${D}${ROOT_HOME_DIR}/nina/scripts

    chmod 0755 ${D}${ROOT_HOME_DIR}/nina/scripts/backup.sh
    chmod 0755 ${D}${ROOT_HOME_DIR}/nina/scripts/bank_add.sh
    chmod 0755 ${D}${ROOT_HOME_DIR}/nina/scripts/bank_clear.sh
    chmod 0755 ${D}${ROOT_HOME_DIR}/nina/scripts/bank_export.sh
    chmod 0755 ${D}${ROOT_HOME_DIR}/nina/scripts/bank_import_merge.sh
    chmod 0755 ${D}${ROOT_HOME_DIR}/nina/scripts/bank_import_merge_check.sh
    chmod 0755 ${D}${ROOT_HOME_DIR}/nina/scripts/bank_import_overwrite.sh
    chmod 0755 ${D}${ROOT_HOME_DIR}/nina/scripts/calibrate.sh
    chmod 0755 ${D}${ROOT_HOME_DIR}/nina/scripts/factory_calibrate.sh
    chmod 0755 ${D}${ROOT_HOME_DIR}/nina/scripts/loadWt.sh
    chmod 0755 ${D}${ROOT_HOME_DIR}/nina/scripts/log_temp.sh
    chmod 0755 ${D}${ROOT_HOME_DIR}/nina/scripts/restore_backup.sh
    chmod 0755 ${D}${ROOT_HOME_DIR}/nina/scripts/wt_export.sh
    chmod 0755 ${D}${ROOT_HOME_DIR}/nina/scripts/wt_import.sh
    chmod 0755 ${D}${ROOT_HOME_DIR}/nina/scripts/wt_prune.sh

    # Add a temporary file to the /usr/bin folder that can be deleted to create space in rootfs
    # if needed
    install -d ${D}${bindir}
    install -m 0666 ${WORKDIR}/bin.tmp ${D}${bindir}  

    # Workaround - copy to the deploy image directory, which are then
    # copied into the userdata (/udata) partition
    # Note - make the deploy directory if it doesn't exist
    if ! [ -d ${DEPLOY_DIR_IMAGE} ]; then
        mkdir -p ${DEPLOY_DIR_IMAGE}
    fi
    chmod 0755 ${DEPLOY_DIR_IMAGE}    
    cp ${WORKDIR}/git/nina/nina_ui/config.json ${DEPLOY_DIR_IMAGE}/config.json
    cp ${WORKDIR}/git/nina/nina_ui/global_params.json ${DEPLOY_DIR_IMAGE}/global_params.json
    cp ${WORKDIR}/git/nina/test_patches/001_TEST_VCO_1_TRI.json ${DEPLOY_DIR_IMAGE}/001_TEST_VCO_1_TRI.json
    cp ${WORKDIR}/git/nina/test_patches/002_TEST_VCO_1_SQR.json ${DEPLOY_DIR_IMAGE}/002_TEST_VCO_1_SQR.json
    cp ${WORKDIR}/git/nina/test_patches/003_TEST_VCO_2_TRI.json ${DEPLOY_DIR_IMAGE}/003_TEST_VCO_2_TRI.json
    cp ${WORKDIR}/git/nina/test_patches/004_TEST_VCO_2_SQR.json ${DEPLOY_DIR_IMAGE}/004_TEST_VCO_2_SQR.json
    cp ${WORKDIR}/git/nina/test_patches/005_TEST_VCO_2_SYNC.json ${DEPLOY_DIR_IMAGE}/005_TEST_VCO_2_SYNC.json
    cp ${WORKDIR}/git/nina/test_patches/006_TEST_OSC_3.json ${DEPLOY_DIR_IMAGE}/006_TEST_OSC_3.json
    cp ${WORKDIR}/git/nina/test_patches/007_VCF_SELF_CHIRP.json ${DEPLOY_DIR_IMAGE}/007_VCF_SELF_CHIRP.json
    cp ${WORKDIR}/git/nina/test_patches/008_VCA_LEFT_RIGHT_SPIN.json ${DEPLOY_DIR_IMAGE}/008_VCA_LEFT_RIGHT_SPIN.json
    cp ${WORKDIR}/git/nina/test_patches/009_TEST_FX.json ${DEPLOY_DIR_IMAGE}/009_TEST_FX.json
    cp ${WORKDIR}/git/nina/test_patches/010_VOICE_SILENCE_TEST.json ${DEPLOY_DIR_IMAGE}/010_VOICE_SILENCE_TEST.json
    cp ${WORKDIR}/git/nina/test_patches/011_TEST_PLAY.json ${DEPLOY_DIR_IMAGE}/011_TEST_PLAY.json
    cp ${WORKDIR}/git/nina/test_patches/012_VCF_SELF_OSC.json ${DEPLOY_DIR_IMAGE}/012_VCF_SELF_OSC.json
    cp ${WORKDIR}/git/nina/test_patches/013_TEST_ARP.json ${DEPLOY_DIR_IMAGE}/013_TEST_ARP.json
    cp ${WORKDIR}/git/nina/test_patches/014_TEST_VCO_1_SUB.json ${DEPLOY_DIR_IMAGE}/014_TEST_VCO_1_SUB.json
    cp ${WORKDIR}/git/nina/test_patches/015_TEST_ENCODERS.json ${DEPLOY_DIR_IMAGE}/015_TEST_ENCODERS.json
    cp ${WORKDIR}/git/nina/test_patches/016_TEST_VCO_WIDTH.json ${DEPLOY_DIR_IMAGE}/016_TEST_VCO_WIDTH.json
    cp ${WORKDIR}/git/nina/test_patches/017_TEST_TEMPLATE.json ${DEPLOY_DIR_IMAGE}/017_TEST_TEMPLATE.json
    cp ${WORKDIR}/wavetables.tar.xz ${DEPLOY_DIR_IMAGE}/wavetables.tar.xz
}

FILES_${PN} += "${ROOT_HOME_DIR}"
FILES_${PN} += "${ROOT_HOME_DIR}/*"
FILES_${PN} += "${NINA_HOME_DIR}"
FILES_${PN} += "${NINA_HOME_DIR}/*"
