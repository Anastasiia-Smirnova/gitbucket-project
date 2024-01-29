
package gitbucket.core.dashboard.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object tab extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[Boolean,String,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(enableNewsFeed: Boolean, active: String = "")(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(if(enableNewsFeed || context.loginAccount.isDefined)/*2.54*/ {_display_(Seq[Any](format.raw/*2.56*/("""
  """),format.raw/*3.3*/("""<ul class="nav nav-tabs" style="margin-bottom: 20px;">
    """),_display_(if(enableNewsFeed)/*4.24*/ {_display_(Seq[Any](format.raw/*4.26*/("""
      """),format.raw/*5.7*/("""<li """),_display_(if(active == "")/*5.28*/ {_display_(Seq[Any](format.raw/*5.30*/("""class="active"""")))} else {null} ),format.raw/*5.45*/("""><a href=""""),_display_(/*5.56*/context/*5.63*/.path),format.raw/*5.68*/("""/">News feed</a></li>
    """)))} else {null} ),format.raw/*6.6*/("""
    """),_display_(if(context.loginAccount.isDefined)/*7.40*/ {_display_(Seq[Any](format.raw/*7.42*/("""
      """),format.raw/*8.7*/("""<li """),_display_(if(active == "repos")/*8.33*/ {_display_(Seq[Any](format.raw/*8.35*/("""class="active"""")))} else {null} ),format.raw/*8.50*/("""><a href=""""),_display_(/*8.61*/context/*8.68*/.path),format.raw/*8.73*/("""/dashboard/repos">Repositories</a></li>
      <li """),_display_(if(active == "pulls")/*9.33*/ {_display_(Seq[Any](format.raw/*9.35*/("""class="active"""")))} else {null} ),format.raw/*9.50*/("""><a href=""""),_display_(/*9.61*/context/*9.68*/.path),format.raw/*9.73*/("""/dashboard/pulls">Pull requests</a></li>
      <li """),_display_(if(active == "issues")/*10.34*/ {_display_(Seq[Any](format.raw/*10.36*/("""class="active"""")))} else {null} ),format.raw/*10.51*/("""><a href=""""),_display_(/*10.62*/context/*10.69*/.path),format.raw/*10.74*/("""/dashboard/issues">Issues</a></li>
      """),_display_(/*11.8*/gitbucket/*11.17*/.core.plugin.PluginRegistry().getDashboardTabs.map/*11.67*/ { tab =>_display_(Seq[Any](format.raw/*11.76*/("""
        """),_display_(/*12.10*/tab(context)/*12.22*/.map/*12.26*/ { link =>_display_(Seq[Any](format.raw/*12.36*/("""
          """),format.raw/*13.11*/("""<li """),_display_(if(active == link.id)/*13.37*/ {_display_(Seq[Any](format.raw/*13.39*/("""class="active"""")))} else {null} ),format.raw/*13.54*/("""><a href=""""),_display_(/*13.65*/context/*13.72*/.path),format.raw/*13.77*/("""/"""),_display_(/*13.79*/link/*13.83*/.path),format.raw/*13.88*/("""">"""),_display_(/*13.91*/link/*13.95*/.label),format.raw/*13.101*/("""</a></li>
        """)))}),format.raw/*14.10*/("""
      """)))}),format.raw/*15.8*/("""
    """)))} else {null} ),format.raw/*16.6*/("""
  """),format.raw/*17.3*/("""</ul>
""")))} else {null} ),format.raw/*18.2*/("""
"""))
      }
    }
  }

  def render(enableNewsFeed:Boolean,active:String,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(enableNewsFeed,active)(context)

  def f:((Boolean,String) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (enableNewsFeed,active) => (context) => apply(enableNewsFeed,active)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/dashboard/tab.scala.html
                  HASH: 90088a8596e9ca03247992478a87289be92c327a
                  MATRIX: 625->1|871->154|910->156|939->159|1043->237|1082->239|1115->246|1162->267|1201->269|1259->284|1296->295|1311->302|1336->307|1405->334|1471->374|1510->376|1543->383|1595->409|1634->411|1692->426|1729->437|1744->444|1769->449|1867->521|1906->523|1964->538|2001->549|2016->556|2041->561|2142->635|2182->637|2241->652|2279->663|2295->670|2321->675|2389->717|2407->726|2466->776|2513->785|2550->795|2571->807|2584->811|2632->821|2671->832|2724->858|2764->860|2823->875|2861->886|2877->893|2903->898|2932->900|2945->904|2971->909|3001->912|3014->916|3042->922|3092->941|3130->949|3179->955|3209->958|3259->965
                  LINES: 14->1|19->2|19->2|20->3|21->4|21->4|22->5|22->5|22->5|22->5|22->5|22->5|22->5|23->6|24->7|24->7|25->8|25->8|25->8|25->8|25->8|25->8|25->8|26->9|26->9|26->9|26->9|26->9|26->9|27->10|27->10|27->10|27->10|27->10|27->10|28->11|28->11|28->11|28->11|29->12|29->12|29->12|29->12|30->13|30->13|30->13|30->13|30->13|30->13|30->13|30->13|30->13|30->13|30->13|30->13|30->13|31->14|32->15|33->16|34->17|35->18
                  -- GENERATED --
              */
          