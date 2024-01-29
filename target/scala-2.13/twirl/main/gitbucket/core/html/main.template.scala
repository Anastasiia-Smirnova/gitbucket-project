
package gitbucket.core.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object main extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template5[String,Option[gitbucket.core.service.RepositoryService.RepositoryInfo],String,Html,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String, repository: Option[gitbucket.core.service.RepositoryService.RepositoryInfo] = None, highlighterTheme: String = "github-v2")(body: Html)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*2.2*/import gitbucket.core.plugin.PluginRegistry
/*3.2*/import gitbucket.core.view.helpers


Seq[Any](format.raw/*4.1*/("""<!DOCTYPE html>
<html prefix="og: http://ogp.me/ns#" lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=5.0" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <title>"""),_display_(/*10.13*/title),format.raw/*10.18*/("""</title>
    <meta property="og:title" content=""""),_display_(/*11.41*/title),format.raw/*11.46*/("""" />
    <meta property="og:type" content="object" />
    <meta property="og:url" content=""""),_display_(/*13.39*/context/*13.46*/.request.getRequestURL),format.raw/*13.68*/("""" />
    """),_display_(if(repository.isEmpty)/*14.28*/{_display_(Seq[Any](format.raw/*14.29*/("""
      """),format.raw/*15.7*/("""<meta property="og:image" content=""""),_display_(/*15.43*/context/*15.50*/.baseUrl),format.raw/*15.58*/("""/assets/common/images/gitbucket_ogp.png" />
    """)))} else {null} ),format.raw/*16.6*/("""
    """),_display_(/*17.6*/repository/*17.16*/.map/*17.20*/{ r =>_display_(Seq[Any](format.raw/*17.26*/("""
      """),format.raw/*18.7*/("""<meta property="og:image" content=""""),_display_(/*18.43*/context/*18.50*/.baseUrl),format.raw/*18.58*/("""/"""),_display_(/*18.60*/r/*18.61*/.owner),format.raw/*18.67*/("""/_avatar" />
      """),_display_(/*19.8*/r/*19.9*/.repository.description.map/*19.36*/{ desc =>_display_(Seq[Any](format.raw/*19.45*/("""
        """),format.raw/*20.9*/("""<meta property="og:description" content=""""),_display_(/*20.51*/desc),format.raw/*20.55*/("""" />
      """)))}),format.raw/*21.8*/("""
    """)))}),format.raw/*22.6*/("""
    """),format.raw/*23.5*/("""<link rel="icon" href=""""),_display_(/*23.29*/helpers/*23.36*/.assets("/common/images/gitbucket.png")),format.raw/*23.75*/("""" type="image/vnd.microsoft.icon" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href=""""),_display_(/*25.18*/helpers/*25.25*/.assets("/vendors/google-fonts/css/source-sans-pro.css")),format.raw/*25.81*/("""" rel="stylesheet">
    <link href=""""),_display_(/*26.18*/helpers/*26.25*/.assets("/vendors/bootstrap-3.4.1/css/bootstrap.min.css")),format.raw/*26.82*/("""" rel="stylesheet">
    <link href=""""),_display_(/*27.18*/helpers/*27.25*/.assets("/vendors/octicons-4.4.0/octicons.min.css")),format.raw/*27.76*/("""" rel="stylesheet">
    <link href=""""),_display_(/*28.18*/helpers/*28.25*/.assets("/vendors/bootstrap-datetimepicker-4.17.44/css/bootstrap-datetimepicker.min.css")),format.raw/*28.114*/("""" rel="stylesheet">
    <link href=""""),_display_(/*29.18*/helpers/*29.25*/.assets("/vendors/colorpicker/css/bootstrap-colorpicker.min.css")),format.raw/*29.90*/("""" rel="stylesheet">
    <link href=""""),_display_(/*30.18*/helpers/*30.25*/.assets(s"/vendors/color-themes-for-google-code-prettify/${highlighterTheme}.min.css")),format.raw/*30.111*/("""" type="text/css" rel="stylesheet"/>
    <link href=""""),_display_(/*31.18*/helpers/*31.25*/.assets("/vendors/facebox/facebox.css")),format.raw/*31.64*/("""" rel="stylesheet"/>
    <link href=""""),_display_(/*32.18*/helpers/*32.25*/.assets("/vendors/AdminLTE-2.4.2/css/AdminLTE.min.css")),format.raw/*32.80*/("""" rel="stylesheet">
    <link href=""""),_display_(/*33.18*/helpers/*33.25*/.assets(s"/vendors/AdminLTE-2.4.2/css/skins/${context.settings.skinName}.min.css")),format.raw/*33.107*/("""" rel="stylesheet">
    <link href=""""),_display_(/*34.18*/helpers/*34.25*/.assets("/vendors/font-awesome-4.7.0/css/font-awesome.min.css")),format.raw/*34.88*/("""" rel="stylesheet">
    <link href=""""),_display_(/*35.18*/helpers/*35.25*/.assets("/vendors/jquery-ui/jquery-ui.min.css")),format.raw/*35.72*/("""" rel="stylesheet">
    <link href=""""),_display_(/*36.18*/helpers/*36.25*/.assets("/vendors/jquery-ui/jquery-ui.structure.min.css")),format.raw/*36.82*/("""" rel="stylesheet">
    <link href=""""),_display_(/*37.18*/helpers/*37.25*/.assets("/vendors/jquery-ui/jquery-ui.theme.min.css")),format.raw/*37.78*/("""" rel="stylesheet">
    <link href=""""),_display_(/*38.18*/helpers/*38.25*/.assets("/common/css/gitbucket.css")),format.raw/*38.61*/("""" rel="stylesheet">
    <link href=""""),_display_(/*39.18*/helpers/*39.25*/.assets("/vendors/tipped/tipped.css")),format.raw/*39.62*/("""" rel="stylesheet">
    <script src=""""),_display_(/*40.19*/helpers/*40.26*/.assets("/vendors/jquery/jquery-3.5.1.min.js")),format.raw/*40.72*/(""""></script>
    <script src=""""),_display_(/*41.19*/helpers/*41.26*/.assets("/vendors/jquery-ui/jquery-ui.min.js")),format.raw/*41.72*/(""""></script>
    <script src=""""),_display_(/*42.19*/helpers/*42.26*/.assets("/vendors/dropzone/dropzone.min.js")),format.raw/*42.70*/(""""></script>
    <script src=""""),_display_(/*43.19*/helpers/*43.26*/.assets("/common/js/validation.js")),format.raw/*43.61*/(""""></script>
    <script src=""""),_display_(/*44.19*/helpers/*44.26*/.assets("/common/js/gitbucket.js")),format.raw/*44.60*/(""""></script>
    <script src=""""),_display_(/*45.19*/helpers/*45.26*/.assets("/vendors/bootstrap-3.4.1/js/bootstrap.min.js")),format.raw/*45.81*/(""""></script>
    <script src=""""),_display_(/*46.19*/helpers/*46.26*/.assets("/vendors/bootstrap3-typeahead/bootstrap3-typeahead.min.js")),format.raw/*46.94*/(""""></script>
    <script src=""""),_display_(/*47.19*/helpers/*47.26*/.assets("/vendors/bootstrap-datetimepicker-4.17.44/js/moment.min.js")),format.raw/*47.95*/(""""></script>
    <script src=""""),_display_(/*48.19*/helpers/*48.26*/.assets("/vendors/bootstrap-datetimepicker-4.17.44/js/bootstrap-datetimepicker.min.js")),format.raw/*48.113*/(""""></script>
    <script src=""""),_display_(/*49.19*/helpers/*49.26*/.assets("/vendors/colorpicker/js/bootstrap-colorpicker.min.js")),format.raw/*49.89*/(""""></script>
    <script src=""""),_display_(/*50.19*/helpers/*50.26*/.assets("/vendors/google-code-prettify/prettify.js")),format.raw/*50.78*/(""""></script>
    <script src=""""),_display_(/*51.19*/helpers/*51.26*/.assets("/vendors/elastic/jquery.elastic.source.js")),format.raw/*51.78*/(""""></script>
    <script src=""""),_display_(/*52.19*/helpers/*52.26*/.assets("/vendors/facebox/facebox.js")),format.raw/*52.64*/(""""></script>
    <script src=""""),_display_(/*53.19*/helpers/*53.26*/.assets("/vendors/jquery-hotkeys/jquery.hotkeys.js")),format.raw/*53.78*/(""""></script>
    <script src=""""),_display_(/*54.19*/helpers/*54.26*/.assets("/vendors/jquery-textcomplete-1.8.4/jquery.textcomplete.min.js")),format.raw/*54.98*/(""""></script>
    <script src=""""),_display_(/*55.19*/helpers/*55.26*/.assets("/vendors/tipped/tipped.min.js")),format.raw/*55.66*/(""""></script>
    """),_display_(/*56.6*/repository/*56.16*/.map/*56.20*/ { repository =>_display_(Seq[Any](format.raw/*56.36*/("""
      """),format.raw/*57.7*/("""<meta name="go-import" content=""""),_display_(/*57.40*/context/*57.47*/.baseUrl.replaceFirst("^https?://", "")),format.raw/*57.86*/("""/"""),_display_(/*57.88*/repository/*57.98*/.owner),format.raw/*57.104*/("""/"""),_display_(/*57.106*/repository/*57.116*/.name),format.raw/*57.121*/(""" """),format.raw/*57.122*/("""git """),_display_(/*57.127*/repository/*57.137*/.httpUrl),format.raw/*57.145*/("""" />
    """)))}),format.raw/*58.6*/("""
    """),format.raw/*59.5*/("""<script src=""""),_display_(/*59.19*/helpers/*59.26*/.assets("/vendors/AdminLTE-2.4.2/js/adminlte.min.js")),format.raw/*59.79*/("""" type="text/javascript"></script>
    """),_display_(/*60.6*/context/*60.13*/.settings.userDefinedCss.map/*60.41*/ { css =>_display_(Seq[Any](format.raw/*60.50*/("""
      """),format.raw/*61.7*/("""<style type="text/css">"""),_display_(/*61.31*/css),format.raw/*61.34*/("""</style>
    """)))}),format.raw/*62.6*/("""
  """),format.raw/*63.3*/("""</head>
  <body class=""""),_display_(/*64.17*/context/*64.24*/.settings.skinName),format.raw/*64.42*/(""" """),format.raw/*64.43*/("""page-load """),_display_(if(body.toString.contains("menu-item-hover"))/*64.99*/{_display_(Seq[Any](format.raw/*64.100*/("""sidebar-mini""")))} else {null} ),format.raw/*64.113*/(""" """),_display_(if(context.sidebarCollapse)/*64.142*/{_display_(Seq[Any](format.raw/*64.143*/("""sidebar-collapse""")))} else {null} ),format.raw/*64.160*/("""">
    <div class="wrapper">
      <header class="main-header">
        <a href=""""),_display_(/*67.19*/context/*67.26*/.path),format.raw/*67.31*/("""/" class="logo">
          <span class="logo-mini"><img src=""""),_display_(/*68.46*/helpers/*68.53*/.assets("/common/images/gitbucket.svg")),format.raw/*68.92*/("""" alt="GitBucket" /></span>
          <span class="logo-lg">
            <img src=""""),_display_(/*70.24*/helpers/*70.31*/.assets("/common/images/gitbucket.svg")),format.raw/*70.70*/("""" alt="GitBucket" />
            <span class="header-title strong">GitBucket</span>
          </span>
        </a>
        <nav class="navbar navbar-static-top" role="navigation">
          <!-- Sidebar toggle button-->
          """),_display_(if(body.toString.contains("main-sidebar"))/*76.54*/ {_display_(Seq[Any](format.raw/*76.56*/("""
            """),format.raw/*77.13*/("""<a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button" title="Toggle navigation">
              <span class="sr-only">Toggle navigation</span>
            </a>
          """)))} else {null} ),format.raw/*80.12*/("""
          """),_display_(if(!(context.loginAccount.isEmpty && !context.settings.basicBehavior.allowAnonymousAccess))/*81.103*/ {_display_(Seq[Any](format.raw/*81.105*/("""
            """),format.raw/*82.13*/("""<form id="search" action=""""),_display_(/*82.40*/context/*82.47*/.path),format.raw/*82.52*/("""/search" method="GET" class="pc navbar-form navbar-left" role="search">
              <div class="form-group">
                <input type="text" name="query" id="navbar-search-input" class="form-control" placeholder="Find a repository" aria-label="Search"/>
              </div>
            </form>
            <ul class="pc nav navbar-nav">
              <li><a href=""""),_display_(/*88.29*/context/*88.36*/.path),format.raw/*88.41*/("""/dashboard/pulls">Pull requests</a></li>
              <li><a href=""""),_display_(/*89.29*/context/*89.36*/.path),format.raw/*89.41*/("""/dashboard/issues">Issues</a></li>
              """),_display_(/*90.16*/gitbucket/*90.25*/.core.plugin.PluginRegistry().getGlobalMenus.map/*90.73*/ { menu =>_display_(Seq[Any](format.raw/*90.83*/("""
                """),_display_(/*91.18*/menu(context)/*91.31*/.map/*91.35*/ { link =>_display_(Seq[Any](format.raw/*91.45*/("""
                  """),format.raw/*92.19*/("""<li><a href=""""),_display_(/*92.33*/context/*92.40*/.path),format.raw/*92.45*/("""/"""),_display_(/*92.47*/link/*92.51*/.path),format.raw/*92.56*/("""">"""),_display_(/*92.59*/link/*92.63*/.label),format.raw/*92.69*/("""</a></li>
                """)))}),format.raw/*93.18*/("""
              """)))}),format.raw/*94.16*/("""
            """),format.raw/*95.13*/("""</ul>
          """)))} else {null} ),format.raw/*96.12*/("""
          """),format.raw/*97.11*/("""<div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
              """),_display_(if(context.loginAccount.isDefined)/*99.50*/{_display_(Seq[Any](format.raw/*99.51*/("""
                """),format.raw/*100.17*/("""<li class="dropdown notifications-menu">
                  <a class="dropdown-toggle menu" data-toggle="dropdown" href="#" aria-label="Create new…">
                    <i class="octicon octicon-plus" style="color: black;"></i><span class="caret" style="color: black; vertical-align: middle;"></span>
                  </a>
                  <ul class="dropdown-menu pull-right" style="width: auto;">
                    <li>
                      <ul class="menu">
                        """),_display_(if(context.settings.basicBehavior.repositoryOperation.create || context.loginAccount.get.isAdmin)/*107.123*/{_display_(Seq[Any](format.raw/*107.124*/("""
                          """),format.raw/*108.27*/("""<li><a href=""""),_display_(/*108.41*/context/*108.48*/.path),format.raw/*108.53*/("""/new">New repository</a></li>
                        """)))} else {null} ),format.raw/*109.26*/("""
                        """),format.raw/*110.25*/("""<li><a href=""""),_display_(/*110.39*/context/*110.46*/.path),format.raw/*110.51*/("""/groups/new">New group</a></li>
                      </ul>
                    </li>
                  </ul>
                </li>
                <li class="dropdown notifications-menu">
                  <a class="dropdown-toggle menu" data-toggle="dropdown" href="#" data-toggle="tooltip" data-placement="bottom" title="Signed is as """),_display_(/*116.150*/context/*116.157*/.loginAccount.get.userName),format.raw/*116.183*/("""">
                    """),_display_(/*117.22*/helpers/*117.29*/.avatar(context.loginAccount.get.userName, 16)),format.raw/*117.75*/("""<span class="caret" style="color: black; vertical-align: middle;"></span>
                  </a>
                  <ul class="dropdown-menu pull-right" style="width: auto;">
                    <li>
                      <ul class="menu">
                        <li><a href=""""),_display_(/*122.39*/helpers/*122.46*/.url(context.loginAccount.get.userName)),format.raw/*122.85*/("""">Your profile</a></li>
                        <li><a href=""""),_display_(/*123.39*/helpers/*123.46*/.url(context.loginAccount.get.userName)),format.raw/*123.85*/("""/_edit">Account settings</a></li>
                        """),_display_(if(context.loginAccount.get.isAdmin)/*124.62*/{_display_(Seq[Any](format.raw/*124.63*/("""
                          """),format.raw/*125.27*/("""<li><a href=""""),_display_(/*125.41*/context/*125.48*/.path),format.raw/*125.53*/("""/admin/users">System administration</a></li>
                        """)))} else {null} ),format.raw/*126.26*/("""
                        """),format.raw/*127.25*/("""<li><a href=""""),_display_(/*127.39*/context/*127.46*/.path),format.raw/*127.51*/("""/signout">Sign out</a></li>
                      </ul>
                    </li>
                  </ul>
                </li>
              """)))}else/*132.22*/{_display_(Seq[Any](format.raw/*132.23*/("""
                """),format.raw/*133.17*/("""<li>
                  <a href=""""),_display_(/*134.29*/context/*134.36*/.path),format.raw/*134.41*/("""/signin?redirect="""),_display_(/*134.59*/helpers/*134.66*/.urlEncode(context.currentPath)),format.raw/*134.97*/("""" class="pull-right" id="signin">Sign in</a>
                </li>
              """)))}),format.raw/*136.16*/("""
            """),format.raw/*137.13*/("""</ul>
          </div>
        </nav>
      </header>
      """),_display_(/*141.8*/body),format.raw/*141.12*/("""
    """),format.raw/*142.5*/("""</div>
    <script>
      $(function()"""),format.raw/*144.19*/("""{"""),format.raw/*144.20*/("""
        """),format.raw/*149.11*/("""
        """),_display_(if(body.toString.contains("main-sidebar"))/*150.52*/{_display_(Seq[Any](format.raw/*150.53*/("""
          """),format.raw/*151.11*/("""$(".sidebar-toggle").on('click', function(e)"""),format.raw/*151.55*/("""{"""),format.raw/*151.56*/("""
            """),format.raw/*152.13*/("""$.post('"""),_display_(/*152.22*/context/*152.29*/.path),format.raw/*152.34*/("""/sidebar-collapse', """),format.raw/*152.54*/("""{"""),format.raw/*152.55*/(""" """),format.raw/*152.56*/("""collapse: !$('body').hasClass('sidebar-collapse') """),format.raw/*152.106*/("""}"""),format.raw/*152.107*/(""");
          """),format.raw/*153.11*/("""}"""),format.raw/*153.12*/(""");
        """)))} else {null} ),format.raw/*154.10*/("""
      """),format.raw/*155.7*/("""}"""),format.raw/*155.8*/(""");
    </script>
    """),_display_(/*157.6*/PluginRegistry()/*157.22*/.getJavaScript(context.request.getRequestURI).map/*157.71*/ { script =>_display_(Seq[Any](format.raw/*157.83*/("""
      """),format.raw/*158.7*/("""<script>
        """),_display_(/*159.10*/Html(script)),format.raw/*159.22*/("""
      """),format.raw/*160.7*/("""</script>
    """)))}),format.raw/*161.6*/("""
  """),format.raw/*162.3*/("""</body>
</html>
"""))
      }
    }
  }

  def render(title:String,repository:Option[gitbucket.core.service.RepositoryService.RepositoryInfo],highlighterTheme:String,body:Html,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(title,repository,highlighterTheme)(body)(context)

  def f:((String,Option[gitbucket.core.service.RepositoryService.RepositoryInfo],String) => (Html) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (title,repository,highlighterTheme) => (body) => (context) => apply(title,repository,highlighterTheme)(body)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/main.scala.html
                  HASH: ee657f5c54f1004ff5912af1d494dd46126591e9
                  MATRIX: 684->1|961->207|1012->252|1075->287|1372->557|1398->562|1474->611|1500->616|1619->708|1635->715|1678->737|1737->769|1776->770|1810->777|1873->813|1889->820|1918->828|2010->877|2042->883|2061->893|2074->897|2118->903|2152->910|2215->946|2231->953|2260->961|2289->963|2299->964|2326->970|2372->990|2381->991|2417->1018|2464->1027|2500->1036|2569->1078|2594->1082|2636->1094|2672->1100|2704->1105|2755->1129|2771->1136|2831->1175|2987->1304|3003->1311|3080->1367|3144->1404|3160->1411|3238->1468|3302->1505|3318->1512|3390->1563|3454->1600|3470->1607|3581->1696|3645->1733|3661->1740|3747->1805|3811->1842|3827->1849|3935->1935|4016->1989|4032->1996|4092->2035|4157->2073|4173->2080|4249->2135|4313->2172|4329->2179|4433->2261|4497->2298|4513->2305|4597->2368|4661->2405|4677->2412|4745->2459|4809->2496|4825->2503|4903->2560|4967->2597|4983->2604|5057->2657|5121->2694|5137->2701|5194->2737|5258->2774|5274->2781|5332->2818|5397->2856|5413->2863|5480->2909|5537->2939|5553->2946|5620->2992|5677->3022|5693->3029|5758->3073|5815->3103|5831->3110|5887->3145|5944->3175|5960->3182|6015->3216|6072->3246|6088->3253|6164->3308|6221->3338|6237->3345|6326->3413|6383->3443|6399->3450|6489->3519|6546->3549|6562->3556|6671->3643|6728->3673|6744->3680|6828->3743|6885->3773|6901->3780|6974->3832|7031->3862|7047->3869|7120->3921|7177->3951|7193->3958|7252->3996|7309->4026|7325->4033|7398->4085|7455->4115|7471->4122|7564->4194|7621->4224|7637->4231|7698->4271|7741->4288|7760->4298|7773->4302|7827->4318|7861->4325|7921->4358|7937->4365|7997->4404|8026->4406|8045->4416|8073->4422|8103->4424|8123->4434|8150->4439|8180->4440|8213->4445|8233->4455|8263->4463|8303->4473|8335->4478|8376->4492|8392->4499|8466->4552|8532->4592|8548->4599|8585->4627|8632->4636|8666->4643|8717->4667|8741->4670|8785->4684|8815->4687|8866->4711|8882->4718|8921->4736|8950->4737|9033->4793|9073->4794|9131->4807|9188->4836|9228->4837|9290->4854|9399->4936|9415->4943|9441->4948|9530->5010|9546->5017|9606->5056|9717->5140|9733->5147|9793->5186|10093->5459|10133->5461|10174->5474|10407->5663|10538->5766|10579->5768|10620->5781|10674->5808|10690->5815|10716->5820|11114->6191|11130->6198|11156->6203|11252->6272|11268->6279|11294->6284|11371->6334|11389->6343|11446->6391|11494->6401|11539->6419|11561->6432|11574->6436|11622->6446|11669->6465|11710->6479|11726->6486|11752->6491|11781->6493|11794->6497|11820->6502|11850->6505|11863->6509|11890->6515|11948->6542|11995->6558|12036->6571|12097->6588|12136->6599|12285->6721|12324->6722|12370->6739|12987->7327|13028->7328|13084->7355|13126->7369|13143->7376|13170->7381|13270->7436|13324->7461|13366->7475|13383->7482|13410->7487|13777->7825|13795->7832|13844->7858|13896->7882|13913->7889|13981->7935|14286->8212|14303->8219|14364->8258|14454->8320|14471->8327|14532->8366|14655->8461|14695->8462|14751->8489|14793->8503|14810->8510|14837->8515|14952->8585|15006->8610|15048->8624|15065->8631|15092->8636|15259->8785|15299->8786|15345->8803|15406->8836|15423->8843|15450->8848|15496->8866|15513->8873|15566->8904|15680->8986|15722->8999|15810->9060|15836->9064|15869->9069|15936->9107|15966->9108|16004->9254|16084->9306|16124->9307|16164->9318|16237->9362|16267->9363|16309->9376|16346->9385|16363->9392|16390->9397|16439->9417|16469->9418|16499->9419|16579->9469|16610->9470|16652->9483|16682->9484|16739->9496|16774->9503|16803->9504|16852->9526|16878->9542|16937->9591|16988->9603|17023->9610|17069->9628|17103->9640|17138->9647|17184->9662|17215->9665
                  LINES: 14->1|17->2|18->3|21->4|27->10|27->10|28->11|28->11|30->13|30->13|30->13|31->14|31->14|32->15|32->15|32->15|32->15|33->16|34->17|34->17|34->17|34->17|35->18|35->18|35->18|35->18|35->18|35->18|35->18|36->19|36->19|36->19|36->19|37->20|37->20|37->20|38->21|39->22|40->23|40->23|40->23|40->23|42->25|42->25|42->25|43->26|43->26|43->26|44->27|44->27|44->27|45->28|45->28|45->28|46->29|46->29|46->29|47->30|47->30|47->30|48->31|48->31|48->31|49->32|49->32|49->32|50->33|50->33|50->33|51->34|51->34|51->34|52->35|52->35|52->35|53->36|53->36|53->36|54->37|54->37|54->37|55->38|55->38|55->38|56->39|56->39|56->39|57->40|57->40|57->40|58->41|58->41|58->41|59->42|59->42|59->42|60->43|60->43|60->43|61->44|61->44|61->44|62->45|62->45|62->45|63->46|63->46|63->46|64->47|64->47|64->47|65->48|65->48|65->48|66->49|66->49|66->49|67->50|67->50|67->50|68->51|68->51|68->51|69->52|69->52|69->52|70->53|70->53|70->53|71->54|71->54|71->54|72->55|72->55|72->55|73->56|73->56|73->56|73->56|74->57|74->57|74->57|74->57|74->57|74->57|74->57|74->57|74->57|74->57|74->57|74->57|74->57|74->57|75->58|76->59|76->59|76->59|76->59|77->60|77->60|77->60|77->60|78->61|78->61|78->61|79->62|80->63|81->64|81->64|81->64|81->64|81->64|81->64|81->64|81->64|81->64|81->64|84->67|84->67|84->67|85->68|85->68|85->68|87->70|87->70|87->70|93->76|93->76|94->77|97->80|98->81|98->81|99->82|99->82|99->82|99->82|105->88|105->88|105->88|106->89|106->89|106->89|107->90|107->90|107->90|107->90|108->91|108->91|108->91|108->91|109->92|109->92|109->92|109->92|109->92|109->92|109->92|109->92|109->92|109->92|110->93|111->94|112->95|113->96|114->97|116->99|116->99|117->100|124->107|124->107|125->108|125->108|125->108|125->108|126->109|127->110|127->110|127->110|127->110|133->116|133->116|133->116|134->117|134->117|134->117|139->122|139->122|139->122|140->123|140->123|140->123|141->124|141->124|142->125|142->125|142->125|142->125|143->126|144->127|144->127|144->127|144->127|149->132|149->132|150->133|151->134|151->134|151->134|151->134|151->134|151->134|153->136|154->137|158->141|158->141|159->142|161->144|161->144|162->149|163->150|163->150|164->151|164->151|164->151|165->152|165->152|165->152|165->152|165->152|165->152|165->152|165->152|165->152|166->153|166->153|167->154|168->155|168->155|170->157|170->157|170->157|170->157|171->158|172->159|172->159|173->160|174->161|175->162
                  -- GENERATED --
              */
          