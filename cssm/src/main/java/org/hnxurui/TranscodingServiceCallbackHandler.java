/**
 * TranscodingServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.7  Built on : Nov 20, 2017 (11:41:20 GMT)
 */
package org.hnxurui;


/**
 *  TranscodingServiceCallbackHandler Callback class, Users can extend this class and implement
 *  their own receiveResult and receiveError methods.
 */
public abstract class TranscodingServiceCallbackHandler {
    protected Object clientData;

    /**
     * User can pass in any object that needs to be accessed once the NonBlocking
     * Web service call is finished and appropriate method of this CallBack is called.
     * @param clientData Object mechanism by which the user can pass in user data
     * that will be avilable at the time this callback is called.
     */
    public TranscodingServiceCallbackHandler(Object clientData) {
        this.clientData = clientData;
    }

    /**
     * Please use this constructor if you don't want to set any clientData
     */
    public TranscodingServiceCallbackHandler() {
        this.clientData = null;
    }

    /**
     * Get the client data
     */
    public Object getClientData() {
        return clientData;
    }

    /**
     * auto generated Axis2 call back method for getServerIpAddress method
     * override this method for handling normal response from getServerIpAddress operation
     */
    public void receiveResultgetServerIpAddress(
        org.hnxurui.TranscodingServiceStub.GetServerIpAddressResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getServerIpAddress operation
     */
    public void receiveErrorgetServerIpAddress(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for closeSingleJFmpeg method
     * override this method for handling normal response from closeSingleJFmpeg operation
     */
    public void receiveResultcloseSingleJFmpeg(
        org.hnxurui.TranscodingServiceStub.CloseSingleJFmpegResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from closeSingleJFmpeg operation
     */
    public void receiveErrorcloseSingleJFmpeg(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getRunningCount method
     * override this method for handling normal response from getRunningCount operation
     */
    public void receiveResultgetRunningCount(
        org.hnxurui.TranscodingServiceStub.GetRunningCountResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getRunningCount operation
     */
    public void receiveErrorgetRunningCount(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for openSingleJFmpeg method
     * override this method for handling normal response from openSingleJFmpeg operation
     */
    public void receiveResultopenSingleJFmpeg(
        org.hnxurui.TranscodingServiceStub.OpenSingleJFmpegResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from openSingleJFmpeg operation
     */
    public void receiveErroropenSingleJFmpeg(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getRunningList method
     * override this method for handling normal response from getRunningList operation
     */
    public void receiveResultgetRunningList(
        org.hnxurui.TranscodingServiceStub.GetRunningListResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getRunningList operation
     */
    public void receiveErrorgetRunningList(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for resetEnvironment method
     * override this method for handling normal response from resetEnvironment operation
     */
    public void receiveResultresetEnvironment(
        org.hnxurui.TranscodingServiceStub.ResetEnvironmentResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from resetEnvironment operation
     */
    public void receiveErrorresetEnvironment(java.lang.Exception e) {
    }
}
