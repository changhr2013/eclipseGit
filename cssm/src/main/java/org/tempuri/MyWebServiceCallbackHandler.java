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
     * auto generated Axis2 call back method for closeOneJFmpeg method
     * override this method for handling normal response from closeOneJFmpeg operation
     */
    public void receiveResultcloseOneJFmpeg(
        org.tempuri.MyWebServiceStub.CloseOneJFmpegResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from closeOneJFmpeg operation
     */
    public void receiveErrorcloseOneJFmpeg(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getCurrentStreamListByRegion method
     * override this method for handling normal response from getCurrentStreamListByRegion operation
     */
    public void receiveResultgetCurrentStreamListByRegion(
        org.tempuri.MyWebServiceStub.GetCurrentStreamListByRegionResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getCurrentStreamListByRegion operation
     */
    public void receiveErrorgetCurrentStreamListByRegion(java.lang.Exception e) {
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
     * auto generated Axis2 call back method for closeStreamListByRegion method
     * override this method for handling normal response from closeStreamListByRegion operation
     */
    public void receiveResultcloseStreamListByRegion(
        org.tempuri.MyWebServiceStub.CloseStreamListByRegionResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from closeStreamListByRegion operation
     */
    public void receiveErrorcloseStreamListByRegion(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for openAllStream method
     * override this method for handling normal response from openAllStream operation
     */
    public void receiveResultopenAllStream(
        org.tempuri.MyWebServiceStub.OpenAllStreamResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from openAllStream operation
     */
    public void receiveErroropenAllStream(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getAllRegionList method
     * override this method for handling normal response from getAllRegionList operation
     */
    public void receiveResultgetAllRegionList(
        org.tempuri.MyWebServiceStub.GetAllRegionListResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getAllRegionList operation
     */
    public void receiveErrorgetAllRegionList(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for closeAllStream method
     * override this method for handling normal response from closeAllStream operation
     */
    public void receiveResultcloseAllStream(
        org.tempuri.MyWebServiceStub.CloseAllStreamResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from closeAllStream operation
     */
    public void receiveErrorcloseAllStream(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for openStreamListByRegion method
     * override this method for handling normal response from openStreamListByRegion operation
     */
    public void receiveResultopenStreamListByRegion(
        org.tempuri.MyWebServiceStub.OpenStreamListByRegionResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from openStreamListByRegion operation
     */
    public void receiveErroropenStreamListByRegion(java.lang.Exception e) {
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
     * auto generated Axis2 call back method for openOneJFmpeg method
     * override this method for handling normal response from openOneJFmpeg operation
     */
    public void receiveResultopenOneJFmpeg(
        org.tempuri.MyWebServiceStub.OpenOneJFmpegResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from openOneJFmpeg operation
     */
    public void receiveErroropenOneJFmpeg(java.lang.Exception e) {
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
