#include "circle.hpp"

//First we are going to make the three circles in the same line

#include <iostream>
#include <cmath>
#include <string>
#include <jni.h>

using namespace std;


//For this function the radius must fulfill the condition r1 = r2 + r3
extern "C"
JNIEXPORT void JNICALL Java_com_example_jose_codetestimmote_DrawingActivity_calculateCoordinates(JNIEnv* env, jobject this_obj, jobject circle1, jobject circle2, jobject circle3){
	//In this function we have the radius of the circles, knowing that we want to put them in the same line
	//We are going to put them in the line 0
    jclass cls = env->GetObjectClass(circle1);
    jfieldID xID = env->GetFieldID(cls, "centerX_", "F");
    jfieldID yID = env->GetFieldID(cls, "centerY_", "F");
    jfieldID rID = env->GetFieldID(cls, "radius_", "F");

    float x1, x2, x3, y1, y2, y3;
	x1 = 0;
    y1 = 0;
    y2 = 0;
    y3 = 0;
    jfloat r3 = env->GetFloatField(circle3, rID);
	x2 = 0 - r3;

    jfloat r2 = env->GetFloatField(circle2, rID);
	x3 = 0 + r2;

    env->SetFloatField(circle1, xID, x1);
    env->SetFloatField(circle1, yID, y1);
    env->SetFloatField(circle2, xID, x2);
    env->SetFloatField(circle2, yID, y2);
    env->SetFloatField(circle3, xID, x3);
    env->SetFloatField(circle3, yID, y3);

}


//With this function we will calculate the radius of the others circles, using the Descarte's formula
jfloat descartesRadius(jfloat r1, jfloat r2, jfloat r3){

	jfloat k1 = (-1)/r1;
	jfloat k2 = 1/r2;
	jfloat k3 = 1/r3;

	//Now we can have two solutions and we will print both and decide what to choose

	jfloat insideSqrt = abs((k1*k2) + (k2*k3) + (k3*k1));
	jfloat radius = k1 + k2 + k3 + sqrt(insideSqrt);
	jfloat radiusMinus = k1 + k2 + k3 - sqrt(insideSqrt);

	if(radius < 0){
		radius = radiusMinus;
	}

	return 1/radius;
}

extern "C"
JNIEXPORT void JNICALL Java_com_example_jose_codetestimmote_DrawingActivity_calculateTangentCirclesSameLine(JNIEnv* env, jobject this_obj, jobject circle1, jobject circle2, jobject circle3, jobject circle4, jobject circle5){

	//We have to calculate the equation system for solving this problem
	//As we want the circles to be, one inner tangent and the others two outter tangents

    jclass cls = env->GetObjectClass(circle1);
    jfieldID xID = env->GetFieldID(cls, "centerX_", "F");
    jfieldID yID = env->GetFieldID(cls, "centerY_", "F");
    jfieldID rID = env->GetFieldID(cls, "radius_", "F");

	jfloat x1 = env->GetFloatField(circle1, xID);
	jfloat x2 = env->GetFloatField(circle2, xID);
	jfloat r1 = env->GetFloatField(circle1, rID);
	jfloat r2 = env->GetFloatField(circle2, rID);
    jfloat r3 = env->GetFloatField(circle3, rID);

	jfloat r4 = descartesRadius(r1, r2, r3);

	float den = 2*(x1-x2);
	float num = 2*r4*(r2+r1) + pow(r2,2) - pow(r1, 2) - pow(x2,2) + pow(x1,2);
	jfloat x = num/den;

	//Now we can compute the Y of the center of the tangent circle
	num = abs(pow(x-x1,2) - pow(r4-r1, 2));

	jfloat y = sqrt(num);

    env->SetFloatField(circle4, xID, x);
    env->SetFloatField(circle4, yID, y);
    env->SetFloatField(circle4, rID, r4);

    env->SetFloatField(circle5, xID, x);
    env->SetFloatField(circle5, yID, -1*y);
    env->SetFloatField(circle5, rID, r4);

}



void calculateTangentCircles2(Circle circle1, Circle circle2, Circle circle3){

	//We hace to calculate the equation system for solving this problem
	//As we want the circles to be, one inner tangent and the others two outter tangents
	float s1 = 1;
	float s2 = 1;
	float s3 = 1;

	float x1 = circle1.getCenter().x;
	float x2 = circle2.getCenter().x;
	float x3 = circle3.getCenter().x;
	float y1 = circle1.getCenter().y;
	float y2 = circle2.getCenter().y;
	float y3 = circle3.getCenter().y;
	float r1 = circle1.getRadius();
	float r2 = circle2.getRadius();
	float r3 = circle3.getRadius();

	//Then we have to solve the followin equations:
	// (Xs - X1)^2 + (Ys - Y1)^2 = (Rs - S1*R1)^2
	// (Xs - X2)^2 + (Ys - Y2)^2 = (Rs - S2*R2)^2
	// (Xs - X3)^2 + (Ys - Y3)^2 = (Rs - S3*R3)^2

	//Solving the equations we can get 8 solutions, but we are only using two of them that's why I chose the values of S before.
	//We leave Xs and Ys in function of Rs and then solve

	//Xs = M + N*Rs
	//Ys = P + Q*Rs

	//Solving Xs

	float v11 = 2*x2 - 2*x1;
	float v12 = 2*y2 - 2*y1;
	float v13 = x1*x1 - x2*x2 + y1*y1 - y2*y2 - r1*r1 + r2*r2;
	float v14 = 2*s2*r2 - 2*s1*r1;

	float v21 = 2*x3 - 2*x2;
	float v22 = 2*y3 - 2*y2;
	float v23 = x2*x2 - x3*x3 + y2*y2 - y3*y3 - r2*r2 + r3*r3;
	float v24 = 2*s3*r3 - 2*s2*r2;

	float w12 = v12/v11;
	float w13 = v13/v11;
	float w14 = v14/v11;

	float w22 = v22/v21-w12;
	float w23 = v23/v21-w13;
	float w24 = v24/v21-w14;

	float P = -w23/w22;
	float Q = w24/w22;
	float M = -w12*P-w13;
	float N = w14 - w12*Q;

	float a = N*N + Q*Q - 1;
	float b = 2*M*N - 2*N*x1 + 2*P*Q - 2*Q*y1 + 2*s1*r1;
	float c = x1*x1 + M*M - 2*M*x1 + P*P + y1*y1 - 2*P*y1 - r1*r1;

	// Find a root of a quadratic equation. This requires the circle centers not
	// to be e.g. colinear
	float D = b*b-4*a*c;
	float rs = (-b-sqrt(D))/(2*a);
	float xs = M + N * rs;
	float ys = P + Q * rs;

	//We have the circle now
	cout << "Circle tangent: " << endl;
	cout << "Radius: " << rs << endl;
	cout << "Center: " << "(" << xs << ", " << ys << ")" << endl;

	//We can get the other circle using the opposite of xs

}