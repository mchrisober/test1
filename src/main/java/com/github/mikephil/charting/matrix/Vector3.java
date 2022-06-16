package com.github.mikephil.charting.matrix;

import com.github.mikephil.charting.utils.Utils;

public final class Vector3 {
    public static final Vector3 UNIT_X = new Vector3(1.0f, Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON);
    public static final Vector3 UNIT_Y = new Vector3(Utils.FLOAT_EPSILON, 1.0f, Utils.FLOAT_EPSILON);
    public static final Vector3 UNIT_Z = new Vector3(Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON, 1.0f);
    public static final Vector3 ZERO = new Vector3(Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON);
    public float x;
    public float y;
    public float z;

    public Vector3() {
    }

    public final void add(Vector3 vector3) {
        this.x += vector3.x;
        this.y += vector3.y;
        this.z += vector3.z;
    }

    public final Vector3 cross(Vector3 vector3) {
        float f2 = this.y;
        float f3 = vector3.z;
        float f4 = this.z;
        float f5 = vector3.y;
        float f6 = (f2 * f3) - (f4 * f5);
        float f7 = vector3.x;
        float f8 = this.x;
        return new Vector3(f6, (f4 * f7) - (f3 * f8), (f8 * f5) - (f2 * f7));
    }

    public final float distance2(Vector3 vector3) {
        float f2 = this.x - vector3.x;
        float f3 = this.y - vector3.y;
        float f4 = this.z - vector3.z;
        return (f2 * f2) + (f3 * f3) + (f4 * f4);
    }

    public final void divide(float f2) {
        if (f2 != Utils.FLOAT_EPSILON) {
            this.x /= f2;
            this.y /= f2;
            this.z /= f2;
        }
    }

    public final float dot(Vector3 vector3) {
        return (this.x * vector3.x) + (this.y * vector3.y) + (this.z * vector3.z);
    }

    public final float length() {
        return (float) Math.sqrt((double) length2());
    }

    public final float length2() {
        float f2 = this.x;
        float f3 = this.y;
        float f4 = (f2 * f2) + (f3 * f3);
        float f5 = this.z;
        return f4 + (f5 * f5);
    }

    public final void multiply(float f2) {
        this.x *= f2;
        this.y *= f2;
        this.z *= f2;
    }

    public final float normalize() {
        float length = length();
        if (length != Utils.FLOAT_EPSILON) {
            this.x /= length;
            this.y /= length;
            this.z /= length;
        }
        return length;
    }

    public final boolean pointsInSameDirection(Vector3 vector3) {
        return dot(vector3) > Utils.FLOAT_EPSILON;
    }

    public final void set(Vector3 vector3) {
        this.x = vector3.x;
        this.y = vector3.y;
        this.z = vector3.z;
    }

    public final void subtract(Vector3 vector3) {
        this.x -= vector3.x;
        this.y -= vector3.y;
        this.z -= vector3.z;
    }

    public final void subtractMultiple(Vector3 vector3, float f2) {
        this.x -= vector3.x * f2;
        this.y -= vector3.y * f2;
        this.z -= vector3.z * f2;
    }

    public final void zero() {
        set(Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON);
    }

    public Vector3(float[] fArr) {
        set(fArr[0], fArr[1], fArr[2]);
    }

    public Vector3(float f2, float f3, float f4) {
        set(f2, f3, f4);
    }

    public final void add(float f2, float f3, float f4) {
        this.x += f2;
        this.y += f3;
        this.z += f4;
    }

    public final void multiply(Vector3 vector3) {
        this.x *= vector3.x;
        this.y *= vector3.y;
        this.z *= vector3.z;
    }

    public final void set(float f2, float f3, float f4) {
        this.x = f2;
        this.y = f3;
        this.z = f4;
    }

    public Vector3(Vector3 vector3) {
        set(vector3);
    }
}
