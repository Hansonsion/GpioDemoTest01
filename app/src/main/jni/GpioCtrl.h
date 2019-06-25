#include <jni.h>

#ifndef _Included_com_cosofteck_gpiodemo_GpioControl
#define _Included_com_cosofteck_gpiodemo_GpioControl

#ifdef __cplusplus
extern "C" {
#endif

JNIEXPORT jint JNICALL Java_com_cosofteck_gpiodemo_GpioControl_nativeReadGpio(JNIEnv *env, jclass thiz, jstring path);

JNIEXPORT jint JNICALL Java_com_cosofteck_gpiodemo_GpioControl_nativeWriteGpio(JNIEnv *env, jclass thiz, jstring path, jstring value);

#ifdef __cplusplus
}
#endif
#endif
