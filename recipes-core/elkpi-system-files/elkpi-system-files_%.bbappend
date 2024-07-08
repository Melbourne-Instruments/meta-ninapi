SUMMARY = "System files and startup scripts for the ElkPi board"
HOMEPAGE = "https://github.com/elk-audio/meta-elkpi"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append = "\
    file://run_nina_ui \
    file://run_nina_gui \
    file://run_sushi \
    file://fw_env.config \
"

do_install_append() {
    rm -f ${D}${bindir}/connect-midi-apps
    install -m 0755 ${WORKDIR}/run_nina_ui ${D}${bindir}
    install -m 0755 ${WORKDIR}/run_nina_gui ${D}${bindir}
    install -m 0755 ${WORKDIR}/run_sushi ${D}${bindir}
    install -d ${D}${sysconfdir}
    install -m 0644 ${WORKDIR}/fw_env.config ${D}${sysconfdir}/fw_env.config    
}
