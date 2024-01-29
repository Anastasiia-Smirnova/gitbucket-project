
package gitbucket.core.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template5[List[gitbucket.core.model.Activity],List[gitbucket.core.service.RepositoryService.RepositoryInfo],Boolean,Boolean,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(activities: List[gitbucket.core.model.Activity],
  recentRepositories: List[gitbucket.core.service.RepositoryService.RepositoryInfo],
  showBannerToCreatePersonalAccessToken: Boolean,
  enableNewsFeed: Boolean)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*5.2*/import gitbucket.core.view.helpers


Seq[Any](_display_(/*6.2*/gitbucket/*6.11*/.core.html.main("GitBucket")/*6.39*/{_display_(Seq[Any](format.raw/*6.40*/("""
  """),_display_(/*7.4*/gitbucket/*7.13*/.core.dashboard.html.sidebar(recentRepositories)/*7.61*/{_display_(Seq[Any](format.raw/*7.62*/("""
    """),_display_(/*8.6*/context/*8.13*/.settings.information.map/*8.38*/ { information =>_display_(Seq[Any](format.raw/*8.55*/("""
      """),format.raw/*9.7*/("""<div class="alert alert-info" style="background-color: white; color: #555; border-color: #4183c4; font-size: small; line-height: 120%;">
        <button type="button" class="close" data-dismiss="alert">&times;</button>
        """),_display_(/*11.10*/Html(information)),format.raw/*11.27*/("""
      """),format.raw/*12.7*/("""</div>
    """)))}),format.raw/*13.6*/("""
    """),_display_(if(showBannerToCreatePersonalAccessToken)/*14.47*/{_display_(Seq[Any](format.raw/*14.48*/("""
      """),format.raw/*15.7*/("""<div class="alert alert-info" style="background-color: white; color: #555; border-color: #4183c4; font-size: small; line-height: 120%;">
        <button type="button" class="close" data-dismiss="alert">&times;</button>
        You can
        <a href=""""),_display_(/*18.19*/context/*18.26*/.path),format.raw/*18.31*/("""/"""),_display_(/*18.33*/context/*18.40*/.loginAccount.map(_.userName)),format.raw/*18.69*/("""/_application" style="color: inherit;">
          <strong>create a personal access token</strong>
        </a> and use it in place of a password on the <code>git</code> command line.
      </div>
    """)))} else {null} ),format.raw/*22.6*/("""
    """),_display_(/*23.6*/gitbucket/*23.15*/.core.dashboard.html.tab(enableNewsFeed)),format.raw/*23.55*/("""
    """),format.raw/*24.5*/("""<div class="container">
      """),_display_(if(enableNewsFeed)/*25.26*/ {_display_(Seq[Any](format.raw/*25.28*/("""
        """),format.raw/*26.9*/("""<div class="pull-right">
          <a href=""""),_display_(/*27.21*/context/*27.28*/.path),format.raw/*27.33*/("""/activities.atom"><img src=""""),_display_(/*27.62*/helpers/*27.69*/.assets("/common/images/feed.png")),format.raw/*27.103*/("""" alt="activities"></a>
        </div>
        """),_display_(/*29.10*/gitbucket/*29.19*/.core.helper.html.activities(activities)),format.raw/*29.59*/("""
      """)))}else/*30.14*/{_display_(Seq[Any](format.raw/*30.15*/("""
        """),format.raw/*31.9*/("""<div class="signin-form">
          """),_display_(if(context.settings.basicBehavior.allowAnonymousAccess)/*32.67*/{_display_(Seq[Any](format.raw/*32.68*/("""
            """),_display_(/*33.14*/context/*33.21*/.settings.information.map/*33.46*/ { information =>_display_(Seq[Any](format.raw/*33.63*/("""
              """),format.raw/*34.15*/("""<div class="alert alert-info" style="background-color: white; color: #555; border-color: #4183c4; font-size: small; line-height: 120%;">
                <button type="button" class="close" data-dismiss="alert">&times;</button>
                """),_display_(/*36.18*/Html(information)),format.raw/*36.35*/("""
              """),format.raw/*37.15*/("""</div>
            """)))}),format.raw/*38.14*/("""
          """)))} else {null} ),format.raw/*39.12*/("""
          """),_display_(/*40.12*/gitbucket/*40.21*/.core.html.signinform(context.settings)),format.raw/*40.60*/("""
        """),format.raw/*41.9*/("""</div>
      """)))}),format.raw/*42.8*/("""
    """),format.raw/*43.5*/("""</div>
  """)))}),format.raw/*44.4*/("""
""")))}),format.raw/*45.2*/("""
"""))
      }
    }
  }

  def render(activities:List[gitbucket.core.model.Activity],recentRepositories:List[gitbucket.core.service.RepositoryService.RepositoryInfo],showBannerToCreatePersonalAccessToken:Boolean,enableNewsFeed:Boolean,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(activities,recentRepositories,showBannerToCreatePersonalAccessToken,enableNewsFeed)(context)

  def f:((List[gitbucket.core.model.Activity],List[gitbucket.core.service.RepositoryService.RepositoryInfo],Boolean,Boolean) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (activities,recentRepositories,showBannerToCreatePersonalAccessToken,enableNewsFeed) => (context) => apply(activities,recentRepositories,showBannerToCreatePersonalAccessToken,enableNewsFeed)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/index.scala.html
                  HASH: ef1c2214c6b30a0192ddd5ceda3f47ca004567e6
                  MATRIX: 716->1|1053->267|1116->303|1133->312|1169->340|1207->341|1236->345|1253->354|1309->402|1347->403|1378->409|1393->416|1426->441|1480->458|1513->465|1768->693|1806->710|1840->717|1882->729|1956->776|1995->777|2029->784|2309->1037|2325->1044|2351->1049|2380->1051|2396->1058|2446->1087|2690->1288|2722->1294|2740->1303|2801->1343|2833->1348|2909->1397|2949->1399|2985->1408|3057->1453|3073->1460|3099->1465|3155->1494|3171->1501|3227->1535|3302->1583|3320->1592|3381->1632|3412->1646|3451->1647|3487->1656|3606->1748|3645->1749|3686->1763|3702->1770|3736->1795|3791->1812|3834->1827|4105->2071|4143->2088|4186->2103|4237->2123|4293->2135|4332->2147|4350->2156|4410->2195|4446->2204|4490->2218|4522->2223|4562->2233|4594->2235
                  LINES: 14->1|20->5|23->6|23->6|23->6|23->6|24->7|24->7|24->7|24->7|25->8|25->8|25->8|25->8|26->9|28->11|28->11|29->12|30->13|31->14|31->14|32->15|35->18|35->18|35->18|35->18|35->18|35->18|39->22|40->23|40->23|40->23|41->24|42->25|42->25|43->26|44->27|44->27|44->27|44->27|44->27|44->27|46->29|46->29|46->29|47->30|47->30|48->31|49->32|49->32|50->33|50->33|50->33|50->33|51->34|53->36|53->36|54->37|55->38|56->39|57->40|57->40|57->40|58->41|59->42|60->43|61->44|62->45
                  -- GENERATED --
              */
          