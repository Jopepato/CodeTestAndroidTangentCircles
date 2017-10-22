#ifndef CIRCLE_HPP_
#define CIRCLE_HPP_
#include <jni.h>
//Definition of the center of the circle
struct Center{
	float x;
	float y;
};


class Circle{

	private:
		Center center_;
		float radius_;

	public:

		//Constructors
		Circle();
		inline Circle(float radius){
			setRadius(radius);
		};

		inline Circle(Center center, float radius){
			setCenter(center);
			setRadius(radius);
		};

		//Getters and setters
		inline Center getCenter(){
			return center_;
		};

		inline void setCenter(Center center){
			center_ = center;
		};

		inline float getRadius(){
			return radius_;
		};

		inline void setRadius(float radius){
			radius_ = radius;
		}
};



#endif