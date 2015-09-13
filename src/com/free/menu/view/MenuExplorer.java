package com.free.menu.view;

import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.part.ViewPart;

import com.free.menu.model.Person;


public class MenuExplorer extends ViewPart { 
    private TreeViewer treeViewer; 
    private MenuManager fMenuMgr; 
    private Menu fMenu; 
    private static MenuExplorer fInstance = null; 
    public MenuExplorer() { 
        fInstance = this; 
    } 
    public static MenuExplorer getInstance(){ 
        return fInstance; 
    } 
    public void createPartControl(Composite parent) { 
        treeViewer = new TreeViewer (parent, SWT.MULTI); 
        //treeViewer.setLabelProvider(new PersonListLabelProvider()); 
        //treeViewer.setContentProvider(new PersonTreeContentProvider()); 
        
        treeViewer.setLabelProvider(new ViewLabelProvider()); 
        treeViewer.setContentProvider(new FileTreeContentProvider()); 
        
        treeViewer.setInput(Person.example()); 
        this.getSite().setSelectionProvider(treeViewer); 
        hookContextMenu(); 
        fInstance = this; 
        
    } 
    public void setViewMenuActionState(boolean state){        
        //JokeCommand.setState(state); 
        viewMenuAction(); 
    } 
    private  void viewMenuAction() { 
        IActionBars bars= getViewSite().getActionBars(); 
        final IMenuManager menu= bars.getMenuManager();    
        
       /* UIOperation.asyncExecCommand(new Runnable(){ 
            public void run() { 
                menu.update("com.free.menu.commands.jokeAction"); 
            }            
        });   */     
    } 
    private void hookContextMenu() { 
        fMenuMgr = new MenuManager("#PopupMenu"); 
        fMenuMgr.setRemoveAllWhenShown(true); 
        fMenuMgr.addMenuListener(new IMenuListener() { 
            public void menuAboutToShow(IMenuManager manager) {                
            } 
        }); 
        fMenu = fMenuMgr.createContextMenu(treeViewer.getControl()); 

        treeViewer.getControl().setMenu(fMenu); 
        getSite().registerContextMenu(fMenuMgr, treeViewer);              
    }    
    public void setFocus() { 
        treeViewer.getTree().setFocus(); 

    } 
 }