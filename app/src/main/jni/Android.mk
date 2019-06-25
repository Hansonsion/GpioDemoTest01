LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE_TAGS := optional

LOCAL_MODULE    := libgpioctrl
LOCAL_SRC_FILES := GpioCtrl.c
LOCAL_LDLIBS	:= -llog -lm -lc

LOCAL_SHARED_LIBRARIES := \
    libcutils \
    libutils 

LOCAL_PRELINK_MODULE := false
include $(BUILD_SHARED_LIBRARY)
