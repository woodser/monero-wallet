/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class monero_cpp_bridge_MoneroCppUtilsJni */

#ifndef _Included_monero_cpp_bridge_MoneroCppUtilsJni
#define _Included_monero_cpp_bridge_MoneroCppUtilsJni
#ifdef __cplusplus
extern "C" {
#endif

/*
 * Class:     monero_cpp_bridge_MoneroCppUtilsJni
 * Method:    jsonToBinary
 * Signature: (Ljava/lang/String;)[I
 */
JNIEXPORT jbyteArray JNICALL Java_monero_cpp_1bridge_MoneroCppUtilsJni_jsonToBinary
  (JNIEnv *, jclass, jstring);

/*
 * Class:     monero_cpp_bridge_MoneroCppUtilsJni
 * Method:    binaryToJson
 * Signature: ([I)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_monero_cpp_1bridge_MoneroCppUtilsJni_binaryToJson
  (JNIEnv *, jclass, jbyteArray);

/*
 * Class:     monero_cpp_bridge_MoneroCppUtilsJni
 * Method:    binaryBlocksToJson
 * Signature: ([I)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_monero_cpp_1bridge_MoneroCppUtilsJni_binaryBlocksToJson
  (JNIEnv *, jclass, jbyteArray);

// TODO: this causes warning
std::string jstring2string(JNIEnv *env, jstring jStr);

#ifdef __cplusplus
}
#endif
#endif
