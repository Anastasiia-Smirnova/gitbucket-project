
package gitbucket.core.dashboard.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object issuesnavi extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template6[String,String,Int,Int,gitbucket.core.service.IssuesService.IssueSearchCondition,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(active: String,
  filter: String,
  openCount: Int,
  closedCount: Int,
  condition: gitbucket.core.service.IssuesService.IssueSearchCondition)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*6.1*/("""<ul class="nav nav-pills pull-left" style="line-height: 14px; margin-bottom: 10px;">
  <li class=""""),_display_(/*7.15*/(if(condition.state == "open"){"active"})),format.raw/*7.56*/("""">
    <a href=""""),_display_(/*8.15*/condition/*8.24*/.copy(state = "open").toURL),format.raw/*8.51*/("""">Open <span class="badge">"""),_display_(/*8.79*/openCount),format.raw/*8.88*/("""</span></a>
  </li>
  <li class=""""),_display_(/*10.15*/(if(condition.state == "closed"){"active"})),format.raw/*10.58*/("""">
    <a href=""""),_display_(/*11.15*/condition/*11.24*/.copy(state = "closed").toURL),format.raw/*11.53*/("""">Closed <span class="badge">"""),_display_(/*11.83*/closedCount),format.raw/*11.94*/("""</span></a>
  </li>
</ul>

<div class="btn-group pull-right" data-toggle="buttons">
  <a class="switch btn btn-default """),_display_(if(filter == "created_by")/*16.63*/{_display_(Seq[Any](format.raw/*16.64*/("""active""")))} else {null} ),format.raw/*16.71*/("""" href=""""),_display_(/*16.80*/context/*16.87*/.path),format.raw/*16.92*/("""/dashboard/"""),_display_(/*16.104*/active),format.raw/*16.110*/("""/created_by"""),_display_(/*16.122*/condition/*16.131*/.copy(author = None, assigned = None).toURL),format.raw/*16.174*/("""">Created</a>
  <a class="switch btn btn-default """),_display_(if(filter == "assigned"  )/*17.63*/{_display_(Seq[Any](format.raw/*17.64*/("""active""")))} else {null} ),format.raw/*17.71*/("""" href=""""),_display_(/*17.80*/context/*17.87*/.path),format.raw/*17.92*/("""/dashboard/"""),_display_(/*17.104*/active),format.raw/*17.110*/("""/assigned"""),_display_(/*17.120*/condition/*17.129*/.copy(author = None, assigned = None).toURL),format.raw/*17.172*/("""">Assigned</a>
  <a class="switch btn btn-default """),_display_(if(filter == "mentioned" )/*18.63*/{_display_(Seq[Any](format.raw/*18.64*/("""active""")))} else {null} ),format.raw/*18.71*/("""" href=""""),_display_(/*18.80*/context/*18.87*/.path),format.raw/*18.92*/("""/dashboard/"""),_display_(/*18.104*/active),format.raw/*18.110*/("""/mentioned"""),_display_(/*18.121*/condition/*18.130*/.copy(author = None, assigned = None).toURL),format.raw/*18.173*/("""">Mentioned</a>
</div>

<script>
$(function()"""),format.raw/*22.13*/("""{"""),format.raw/*22.14*/("""
  """),format.raw/*23.3*/("""$('a.switch').click(function()"""),format.raw/*23.33*/("""{"""),format.raw/*23.34*/("""
    """),format.raw/*24.5*/("""location.href = $(this).attr('href');
  """),format.raw/*25.3*/("""}"""),format.raw/*25.4*/(""");
"""),format.raw/*26.1*/("""}"""),format.raw/*26.2*/(""")
</script>
"""))
      }
    }
  }

  def render(active:String,filter:String,openCount:Int,closedCount:Int,condition:gitbucket.core.service.IssuesService.IssueSearchCondition,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(active,filter,openCount,closedCount,condition)(context)

  def f:((String,String,Int,Int,gitbucket.core.service.IssuesService.IssueSearchCondition) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (active,filter,openCount,closedCount,condition) => (context) => apply(active,filter,openCount,closedCount,condition)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/dashboard/issuesnavi.scala.html
                  HASH: 5f6144e6686846d95654a58f2adfbfc6ec93b65d
                  MATRIX: 697->1|988->199|1113->298|1174->339|1217->356|1234->365|1281->392|1335->420|1364->429|1425->463|1489->506|1533->523|1551->532|1601->561|1658->591|1690->602|1863->748|1902->749|1953->756|1989->765|2005->772|2031->777|2071->789|2099->795|2139->807|2158->816|2223->859|2326->935|2365->936|2416->943|2452->952|2468->959|2494->964|2534->976|2562->982|2600->992|2619->1001|2684->1044|2788->1121|2827->1122|2878->1129|2914->1138|2930->1145|2956->1150|2996->1162|3024->1168|3063->1179|3082->1188|3147->1231|3220->1276|3249->1277|3279->1280|3337->1310|3366->1311|3398->1316|3465->1356|3493->1357|3523->1360|3551->1361
                  LINES: 14->1|23->6|24->7|24->7|25->8|25->8|25->8|25->8|25->8|27->10|27->10|28->11|28->11|28->11|28->11|28->11|33->16|33->16|33->16|33->16|33->16|33->16|33->16|33->16|33->16|33->16|33->16|34->17|34->17|34->17|34->17|34->17|34->17|34->17|34->17|34->17|34->17|34->17|35->18|35->18|35->18|35->18|35->18|35->18|35->18|35->18|35->18|35->18|35->18|39->22|39->22|40->23|40->23|40->23|41->24|42->25|42->25|43->26|43->26
                  -- GENERATED --
              */
          