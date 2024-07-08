DESCRIPTION = "Recipe to build SWUpdate for Nina Audio OS"

LICENSE = "CLOSED"

DISTRO_VERSION = "${SWU_VERSION}"

FILEEXTRAPATHS_prepend = "${THISDIR}/ninapi-audio-os-swu"
SRC_URI = "\
    file://sw-description \
"

IMAGE_DEPENDS = "ninapi-audio-os-image"

SWUPDATE_IMAGES = "nina-firmware"

SWUPDATE_IMAGES_FSTYPES[nina-firmware] = ".ext4.gz"

inherit swupdate
