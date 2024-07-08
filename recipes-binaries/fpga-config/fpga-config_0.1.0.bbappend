SRCREV = "4964a42cc641dfeb15c6b29e8e295d2b60b8ab5b"
PV = "1.0.0+${SRCREV}"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append = "\
    file://synthia_fpga_1.rbf \
    file://synthia_fpga_2.rbf \
"

EXTRA_OECMAKE = "\
    -DCMAKE_BUILD_TYPE=Release \
    -DCMAKE_SKIP_RPATH=TRUE \
"

ROOT_HOME_DIR = "/home/root"

do_install_append() {
    install -d ${D}${ROOT_HOME_DIR}
    install -d ${D}${ROOT_HOME_DIR}/nina
    install -d ${D}${ROOT_HOME_DIR}/nina/firmware    
    cp "${WORKDIR}/synthia_fpga_1.rbf" ${D}${ROOT_HOME_DIR}/nina/firmware
    cp "${WORKDIR}/synthia_fpga_2.rbf" ${D}${ROOT_HOME_DIR}/nina/firmware
}

FILES_${PN} += "${ROOT_HOME_DIR}/nina/firmware/synthia_fpga_1.rbf \
                ${ROOT_HOME_DIR}/nina/firmware/synthia_fpga_2.rbf \
"
