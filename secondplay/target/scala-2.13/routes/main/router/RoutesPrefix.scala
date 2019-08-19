// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Administrator/secondplay/conf/routes
// @DATE:Mon Aug 19 17:20:14 CST 2019


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
