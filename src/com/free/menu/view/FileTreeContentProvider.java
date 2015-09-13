package com.free.menu.view;
import java.io.File;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

class FileTreeContentProvider implements ITreeContentProvider { 
  
 public Object[] getChildren(Object arg0) { 
  //返回树的下一级节点 
  return ((File) arg0).listFiles(); 
 }
 public Object getParent(Object arg0) { 
  //返回树的上一 级节点 
  return ((File) arg0).getParentFile();
 }
 
 public boolean hasChildren(Object arg0) {
  Object[] bj = getChildren(arg0);
  //判断树是否有下一级节点，true为在节点显示"+"信息
  return bj == null ? false : bj.length > 0;
 } 
 
 public Object[] getElements(Object arg0) {
  //打印出树的输入信息，通常用户可以通过输入信息构建树 
  System.out.println(arg0); 
  // File.listRoots()作为树的根节点 
  return File.listRoots();
 }
@Override
public void dispose()
{
    // TODO Auto-generated method stub
    
}

@Override
public void inputChanged(Viewer arg0, Object arg1, Object arg2)
{
    
}
}