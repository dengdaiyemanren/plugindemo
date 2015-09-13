package com.free.menu.view;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

class ViewLabelProvider implements IBaseLabelProvider {

  public String getText(Object obj) {
   return obj.toString(); 
  } 
  public Image getImage(Object obj) { 
   String imageKey = ISharedImages.IMG_OBJ_ELEMENT; 
  /* if (obj instanceof ITreeParent)
      imageKey = ISharedImages.IMG_OBJ_FOLDER; */
   return PlatformUI.getWorkbench().getSharedImages().getImage(imageKey); 
  }
@Override
public void addListener(ILabelProviderListener arg0)
{
    // TODO Auto-generated method stub
    
}
@Override
public void dispose()
{
    // TODO Auto-generated method stub
    
}
@Override
public boolean isLabelProperty(Object arg0, String arg1)
{
    // TODO Auto-generated method stub
    return false;
}
@Override
public void removeListener(ILabelProviderListener arg0)
{
    // TODO Auto-generated method stub
    
} 

 }
