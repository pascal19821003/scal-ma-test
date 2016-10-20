package org.pascal

/**
  * Created by Pascal on 2016/9/29.
  */
object FileMatcher {
  private def fileHere = (new java.io.File(".")).listFiles

  def filesEnding(query: String) =
    for (file <- fileHere; if file.getName.matches(query))
      yield file

  def filesMatching(query:String, matcher:(String, String)=>Boolean) = {
    for(file<-fileHere; if matcher(file.getName, query))
      yield  file
  }

  def filesEnding1 (query :String)  = filesMatching(query, _.endsWith(_))
  def filesContains(query : String ) = filesMatching(query, _.contains(_))
  def filesRegex(query: String ) = filesMatching(query, _.matches(_))

  def filesMatching2 (matcher:String => Boolean ) =
    for(file <- fileHere ; if matcher(file.getName))
      yield file

  def fileEnding2(query : String ) =
    filesMatching2(_.endsWith(query))

  def fileContains(query: String ) =
    filesMatching2(_.contains(query))

  def filesRegex2(query: String ) =
    filesMatching2(_.matches(query))
}
