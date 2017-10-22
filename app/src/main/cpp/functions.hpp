#ifndef FUNCTIONS_HPP_
#define FUNCTIONS_HPP_

#include "circle.hpp"
#include <jni.h>


//Definitions of the functions we are going to use

JNIEXPORT void JNICALL Java_com_example_jose_codetestimmote_DrawingActivity_calculateCoordinates(JNIEnv* env, jclass classZ, jobject circle1, jobject circle2, jobject circle3);

void calculateTangentCircles(Circle circle1, Circle circle2, Circle circle3);

void calculateTangentCirclesSameLine(Circle circle1, Circle circle2, Circle circle3);

float descartesRadius(Circle circle1, Circle circle2, Circle circle3);


#endif