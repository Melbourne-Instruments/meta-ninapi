SRCREV = "e384c73ed25f4543bb3b44531a112eadb8260985"
PV = "1.3.0+${SRCREV}"
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append = "\
    file://1.patch \
"
