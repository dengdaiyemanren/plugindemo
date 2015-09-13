package com.free.menu.view;
import java.io.File;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

class FileTreeContentProvider implements ITreeContentProvider { 
  
 public Object[] getChildren(Object arg0) { 
  //����������һ���ڵ� 
  return ((File) arg0).listFiles(); 
 }
 public Object getParent(Object arg0) { 
  //����������һ ���ڵ� 
  return ((File) arg0).getParentFile();
 }
 
 public boolean hasChildren(Object arg0) {
  Object[] bj = getChildren(arg0);
  //�ж����Ƿ�����һ���ڵ㣬trueΪ�ڽڵ���ʾ"+"��Ϣ
  return bj == null ? false : bj.length > 0;
 } 
 
 public Object[] getElements(Object arg0) {
  //��ӡ������������Ϣ��ͨ���û�����ͨ��������Ϣ������ 
  System.out.println(arg0); 
  // File.listRoots()��Ϊ���ĸ��ڵ� 
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