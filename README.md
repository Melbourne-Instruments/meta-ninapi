# meta-ninapi

OpenEmbedded/Yocto Project layer which forms the final product layer for
 creating the NINA OS Image for the NINA Pi Development Kits based on the
 RaspberryPi 4B.

Contains the necessary packages, services, firmware binaries and image recipes
 specific to the NINA Pi Development Kit.

This acts as the **product** layer whose role is to
add further customization of recipes in
 [meta-nina](https://github.com/Melbourne-Instruments/meta-nina) and
 [meta-raspberry-nina](https://github.com/Melbourne-Instruments/meta-raspberrypi-nina) to
 provide the necessary image for the NINA Pi Development Kit.

The specific contributions of this layer are:

  * Selects the specific versions of [NINA-UI](https://github.com/Melbourne-Instruments/nina_ui),
    [NINA-GUI](https://github.com/Melbourne-Instruments/nina_gui),
    [NINA-VST](https://github.com/Melbourne-Instruments/nina_vst),
    [FPGA-CONFIG](https://github.com/Melbourne-Instruments/fpga_config),
    [SUSHI](https://github.com/elk-audio/sushi) and
    [RASPA](https://github.com/Melbourne-Instruments/raspa) and describes their build options.
  * Installs system and user files for NINA Pi Development Kit.
  * Contains the recipes for the images.

## Images

The images provided by this layer are :

  * `ninapi-audio-os-image` : A full development NINA OS image for the NINA Pi
       Kit containing numerous packages and tools. Use this image to generate the
       cross-compiling Yocto SDK.

## Compatible Machines
To build for RaspberryPi4 set `MACHINE = "raspberrypi4-64"` in the local.conf.

## Dependencies

This layer depends on:

  * [meta-nina](https://github.com/Melbourne-Instruments/meta-nina)
  * [meta-raspberry-nina](https://github.com/Melbourne-Instruments/meta-raspberrypi-nina)
  * [meta-swupdate-nina](https://github.com/Melbourne-Instruments/meta-swupdate-nina)
  * [poky](http://git.yoctoproject.org/cgit/cgit.cgi/poky/)
  * [meta-openembedded](https://git.openembedded.org/meta-openembedded)
---

# Creating a prodution NINA OS Image for your device
The goal of this layer is to act as a template to describe and generate an
 image for a  **NINA Powered device**. You can easily customize the recipes
 in this layer and tailor them to your needs.

## Adding files to the image

You can add your custom files (plugin binaries, scripts, samples etc) by
 modifying the
 [ninapi-user-files](recipes-core/ninapi-user-files/ninapi-user-files_0.1.bb) recipe:

  * Add any new files in the [files](recipes-core/ninapi-user-files/files)
    directory and add the new file to the list of sources in the recipe:

```
SRC_URI += "file://your_new_file"
```

  * Add the following line to the `do_install` task to specify where the files should
    be installed:

```
cp -r ${WORKDIR}/your_new_file ${D}path_in_image_rootfs
```
 
## Enabling App automatic startup

You can enable and customize the automatic startup of the NINA apps in the
 image by modifying the recipe
 [elkpi-systemd-services](recipes-core/elkpi-systemd-services/elkpi-systemd-services_0.1.bb):

  * Replace the last line in the recipe
    [elkpi-systemd-services](recipes-core/elkpi-systemd-services/elkpi-systemd-services_0.1.bb)
    with the following:

 ```
 SYSTEMD_AUTO_ENABLE = "enable"
 ```

## Read-Only File System

You can enable an image to have a read-only root file system by adding the following line to an image recipe:

```
IMAGE_FEATURES += "read-only-rootfs"
```

## Adding new packages

You can add new packages to the image in two ways. Usually, OpenEmbedded contains recipes for many packages as standard and you can check if your package is part of the standard list [here](https://layers.openembedded.org/layerindex/branch/warrior/recipes/). If it is not part of OpenEmbedded's list, then you may need to write your own.

Then you can add the desired recipes to any of the [packagegroups](recipes-core/packagegroups) in this layer.

---
Copyright 2021-2023 Melbourne Instruments, Australia.
