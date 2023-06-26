#version 100

#ifdef GL_ES
precision mediump float;
#endif

uniform mat4 u_projTrans;
uniform float u_time;

attribute vec4 a_position;
attribute vec4 a_color;
attribute vec2 a_texCoord0;

varying vec4 v_color;
varying vec2 v_texCoord0;

void main() {
    float factor = a_position.x / 45.0;
    float distortionY = sin(u_time + factor) / 20.0;
    v_color = a_color;
    v_texCoord0 = a_texCoord0;
    gl_Position = u_projTrans * a_position + vec4(0.0, distortionY, 0.0, 0.0);
}