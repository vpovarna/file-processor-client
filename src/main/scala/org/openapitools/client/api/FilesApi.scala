/**
 * Text File Processing API
 * Text File Processing API
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.openapitools.client.api

import org.openapitools.client.model.Error
import org.openapitools.client.model.NewFile
import org.openapitools.client.model.TextFile
import org.openapitools.client.core._
import org.openapitools.client.core.CollectionFormats._
import org.openapitools.client.core.ApiKeyLocations._

object FilesApi {

  def apply(baseUrl: String = "/v1") = new FilesApi(baseUrl)
}

class FilesApi(baseUrl: String) {

  /**
   * Expected answers:
   *   code 201 : String (A new text file was added successfully into the system)
   *   code 500 : String (Unable to add text file into the system)
   * 
   * @param newFile Add a new text file into the system
   */
  def addTextFile(newFile: NewFile): ApiRequest[String] =
    ApiRequest[String](ApiMethods.POST, baseUrl, "/files", "application/json")
      .withBody(newFile)
      .withSuccessResponse[String](201)
      .withErrorResponse[String](500)
      

  /**
   * Expected answers:
   *   code 200 : TextFile (Expected response to a valid request)
   *   code 404 : String (File not found in the system)
   *   code 500 : Error (Internal server error)
   * 
   * @param taskId The id of a text file
   */
  def getFileById(taskId: String): ApiRequest[TextFile] =
    ApiRequest[TextFile](ApiMethods.GET, baseUrl, "/files/{taskId}", "application/json")
      .withPathParam("taskId", taskId)
      .withSuccessResponse[TextFile](200)
      .withErrorResponse[String](404)
      .withErrorResponse[Error](500)
      

  /**
   * Expected answers:
   *   code 200 : Seq[TextFile] (Expected response to a valid request)
   *   code 404 : String (Specified IP address is not in the system)
   *   code 500 : Error (Internal server error)
   * 
   * @param ipAddress An IP address contained by a text file
   */
  def getFileByIpAddress(ipAddress: String): ApiRequest[Seq[TextFile]] =
    ApiRequest[Seq[TextFile]](ApiMethods.GET, baseUrl, "/files/ip/{ipAddress}", "application/json")
      .withPathParam("ipAddress", ipAddress)
      .withSuccessResponse[Seq[TextFile]](200)
      .withErrorResponse[String](404)
      .withErrorResponse[Error](500)
      



}

