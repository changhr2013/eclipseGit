/**
 * MyWebServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.7  Built on : Nov 20, 2017 (11:41:20 GMT)
 */
package org.tempuri;


/**
 *  MyWebServiceCallbackHandler Callback class, Users can extend this class and implement
 *  their own receiveResult and receiveError methods.
 */
public abstract class MyWebServiceCallbackHandler {
    protected Object clientData;

    /**
     * User can pass in any object that needs to be accessed once the NonBlocking
     * Web service call is finished and appropriate method of this CallBack is called.
     * @param clientData Object mechanism by which the user can pass in user data
     * that will be avilable at the time this callback is called.
     */
    public MyWebServiceCallbackHandler(Object clientData) {
        this.clientData = clientData;
    }

    /**
     * Please use this constructor if you don't want to set any clientData
     */
    public MyWebServiceCallbackHandler() {
        this.clientData = null;
    }

    /**
     * Get the client data
     */
    public Object getClientData() {
        return clientData;
    }

    /**
     * auto generated Axis2 call back method for openSingleJFmpeg method
     * override this method for handling normal response from openSingleJFmpeg operation
     */
    public void receiveResultopenSingleJFmpeg(
        org.tempuri.MyWebServiceStub.OpenSingleJFmpegResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from openSingleJFmpeg operation
     */
    public void receiveErroropenSingleJFmpeg(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for resetJFmpeg method
     * override this method for handling normal response from resetJFmpeg operation
     */
    public void receiveResultresetJFmpeg(
        org.tempuri.MyWebServiceStub.ResetJFmpegResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from resetJFmpeg operation
     */
    public void receiveErrorresetJFmpeg(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for runExecute method
     * override this method for handling normal response from runExecute operation
     */
    public void receiveResultrunExecute(
        org.tempuri.MyWebServiceStub.RunExecuteResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from runExecute operation
     */
    public void receiveErrorrunExecute(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getCurrentJFmpegList method
     * override this method for handling normal response from getCurrentJFmpegList operation
     */
    public void receiveResultgetCurrentJFmpegList(
        org.tempuri.MyWebServiceStub.GetCurrentJFmpegListResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getCurrentJFmpegList operation
     */
    public void receiveErrorgetCurrentJFmpegList(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for closeSingleJFmpeg method
     * override this method for handling normal response from closeSingleJFmpeg operation
     */
    public void receiveResultcloseSingleJFmpeg(
        org.tempuri.MyWebServiceStub.CloseSingleJFmpegResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from closeSingleJFmpeg operation
     */
    public void receiveErrorcloseSingleJFmpeg(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getUnusedInOutPort method
     * override this method for handling normal response from getUnusedInOutPort operation
     */
    public void receiveResultgetUnusedInOutPort(
        org.tempuri.MyWebServiceStub.GetUnusedInOutPortResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getUnusedInOutPort operation
     */
    public void receiveErrorgetUnusedInOutPort(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for killAllJFmpegStream method
     * override this method for handling normal response from killAllJFmpegStream operation
     */
    public void receiveResultkillAllJFmpegStream(
        org.tempuri.MyWebServiceStub.KillAllJFmpegStreamResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from killAllJFmpegStream operation
     */
    public void receiveErrorkillAllJFmpegStream(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for runAllConfigJFmpeg method
     * override this method for handling normal response from runAllConfigJFmpeg operation
     */
    public void receiveResultrunAllConfigJFmpeg(
        org.tempuri.MyWebServiceStub.RunAllConfigJFmpegResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from runAllConfigJFmpeg operation
     */
    public void receiveErrorrunAllConfigJFmpeg(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getServerIpAddress method
     * override this method for handling normal response from getServerIpAddress operation
     */
    public void receiveResultgetServerIpAddress(
        org.tempuri.MyWebServiceStub.GetServerIpAddressResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getServerIpAddress operation
     */
    public void receiveErrorgetServerIpAddress(java.lang.Exception e) {
    }
}
