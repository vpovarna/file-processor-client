package org.openapitools

import akka.actor.ActorSystem
import org.openapitools.client.api.FilesApi
import org.openapitools.client.core.{ApiInvoker, ApiResponse}
import org.openapitools.client.model.TextFile

import scala.concurrent.Future

object Demo extends App {
  private val host: String = "http://localhost:18081"
  private implicit val system: ActorSystem = ActorSystem()
  val invoker: ApiInvoker = ApiInvoker()
  import system.dispatcher
  val api = FilesApi(host)

  val apiRequest = api.getFileById("191e513f-0bf4-4b0a-80e9-de9002de6afe")

  val response: Future[ApiResponse[TextFile]] = invoker.execute(apiRequest)

  for {
    fileResponse <- response
  } yield {
    if (fileResponse.code == 200) println(fileResponse.content)
    else println(s"Unable to read the file info. Response code: ${fileResponse.code}")
  }
}
