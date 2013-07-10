package com.tropicdreams.stayintouch;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;

public class CirclePix {
	
	public Bitmap getRoundedShape(Bitmap scaleBitmapImage) {
		  // TODO Auto-generated method stub
		  int targetWidth = 72;
		  int targetHeight = 72;
		 
		  Bitmap targetBitmap = Bitmap.createBitmap(targetWidth, targetHeight,
				  Bitmap.Config.ARGB_8888);
				  Canvas canvas = new Canvas(targetBitmap);
				  Path path = new Path();
				  path.addCircle(((float) targetWidth) / 2,
				  ((float) targetHeight) / 2,
				  (Math.min(((float) targetWidth), ((float) targetHeight)) / 2),
				  Path.Direction.CW);
				  Paint paint = new Paint(); 
				  paint.setColor(Color.GRAY); 
				  //paint.setStyle(Paint.Style.STROKE);
				  paint.setStyle(Paint.Style.FILL);
				  paint.setAntiAlias(true);
				  paint.setDither(true);
				  paint.setFilterBitmap(true);
				  canvas.drawOval(new RectF(0, 0, targetWidth, targetHeight), paint) ;
				  //paint.setColor(Color.TRANSPARENT); 
				  canvas.clipPath(path);
				  Bitmap sourceBitmap = scaleBitmapImage;
				  canvas.drawBitmap(sourceBitmap, new Rect(0, 0, sourceBitmap.getWidth(),
				  sourceBitmap.getHeight()), new RectF(0, 0, targetWidth,
				  targetHeight), paint);
		  return targetBitmap;
	}
}
