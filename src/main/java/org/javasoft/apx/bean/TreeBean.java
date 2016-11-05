/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javasoft.apx.bean;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import lombok.extern.slf4j.Slf4j;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

/**
 *
 * @author ayojava
 */
@Slf4j
@Named("passwordPageBean")
@ViewScoped
public class TreeBean implements Serializable {
    
    private TreeNode root;

    @PostConstruct
    public void init() {
        root = new DefaultTreeNode("root", null);
        
        TreeNode applications = new DefaultTreeNode("Applications", root);
        TreeNode webServices = new DefaultTreeNode("Web Services", root);
        TreeNode jbi = new DefaultTreeNode("JBI", root);
        TreeNode customMBeans = new DefaultTreeNode("Custom MBeans", root);
        TreeNode resources = new DefaultTreeNode("Resources", root);
        TreeNode standAloneInstances = new DefaultTreeNode("Stand Alone Instances", root);
        TreeNode httpLoadBalancers = new DefaultTreeNode("Http Load Balancers", root);
        TreeNode nodeAgents = new DefaultTreeNode("Node Agents", root);
        TreeNode configurations = new DefaultTreeNode("Configurations", root);
    }
}
