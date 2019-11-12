package com.flyingmcdonald.test;

public class TestMethod3 {
	public static void main(String[] args) {
		int R = 255;
		int G = 25;
		int B = 255;
		
		float[] hsv = RGBtoHSV(R,G,B);
		
		System.out.println(hsv[0]+"\n"+hsv[1]+"\n"+hsv[2]);
	}
	
	private static float[] RGBtoHSV(int R, int G, int B) {	 
			int tMax, tMin;
			float H=0,S=0,V=0;
			float delta;
			float tRet[] = new float[3];
			tMax=Math.max(R, Math.max(G,B));
			tMin=Math.min(R, Math.min(G,B));
			if(0 == tMax){
				tRet[0] = 0; 
				tRet[1] = 0;
				tRet[2] = 0; 
				return tRet;
			}
			
			V = tMax; 
			delta = tMax - tMin;
		 
			S = delta / tMax;    		 
			
			if(0 == delta){
				H = 0;
			}else if(G == tMax ){
				H = 2 + (B - R)  / delta; // between cyan & yellow
			}else if(B == tMax){
				H = 4 + (R - G)  / delta; // between magenta & cyan		
			}else if(R == tMax){
				H =  (G - B) / delta;     // between yellow & magenta
			} 		
			 
			H *= 60; 
			if(H < 0 ){
				H += 360;
			}
			
			tRet[0] = H/360.0f; 
			tRet[1] = S;
			tRet[2] = V; 
			return tRet;
		}
	}
