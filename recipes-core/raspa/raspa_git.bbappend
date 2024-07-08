# Specific commit and build options of raspa for NINA Pi boards
PV = "1.0.1"
SRCREV = "c3ecfff665df8435c50d971d3413ebc416800592"

EXTRA_OECMAKE += "\
    -DCMAKE_BUILD_TYPE=Release \
    -DBUILD_GMOCK=FALSE \
    -DINSTALL_GTEST=FALSE \
    -DRASPA_WITH_TESTS=FALSE \
    -DRASPA_WITH_APPS=OFF \
    -DXENOMAI_BASE_DIR=${WORKDIR}/recipe-sysroot/usr/xenomai \
    -DWITH_UNIT_TESTS=FALSE \
    -DELK_PI_HAT=FALSE \
"
