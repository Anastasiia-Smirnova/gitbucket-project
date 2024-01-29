
package gitbucket.core.dashboard.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object sidebar extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[List[gitbucket.core.service.RepositoryService.RepositoryInfo],Html,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(recentRepositories: List[gitbucket.core.service.RepositoryService.RepositoryInfo])(body: Html)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*2.2*/import gitbucket.core.view.helpers


Seq[Any](format.raw/*3.1*/("""<div class="main-sidebar">
  <div class="sidebar">
  <ul class="nav sidebar-menu">
    <li class="header">Recently updated repositories</li>
    """),_display_(if(recentRepositories.isEmpty)/*7.36*/{_display_(Seq[Any](format.raw/*7.37*/("""
      """),format.raw/*8.7*/("""<li>No repositories</li>
    """)))}else/*9.12*/{_display_(Seq[Any](format.raw/*9.13*/("""
      """),format.raw/*10.7*/("""<li><form class="sidebar-form"><input type="text" id="filter-box" class="form-control input-sm" placeholder="Find a repository" aria-label="Search"/></form></li>
      """),_display_(/*11.8*/recentRepositories/*11.26*/.zipWithIndex.map/*11.43*/ { case (repository, i) =>_display_(Seq[Any](format.raw/*11.69*/("""
        """),format.raw/*12.9*/("""<li class="repo-link menu-item-hover">
          <a href=""""),_display_(/*13.21*/helpers/*13.28*/.url(repository)),format.raw/*13.44*/("""">"""),_display_(/*13.47*/gitbucket/*13.56*/.core.helper.html.repositoryicon(repository, false)),format.raw/*13.107*/(""" """),format.raw/*13.108*/("""<span>"""),_display_(/*13.115*/repository/*13.125*/.owner),format.raw/*13.131*/("""/<span class="strong">"""),_display_(/*13.154*/repository/*13.164*/.name),format.raw/*13.169*/("""</span></span></a>
        </li>
      """)))}),format.raw/*15.8*/("""
    """)))}),format.raw/*16.6*/("""
  """),format.raw/*17.3*/("""</ul>
  </div>
</div>
<div class="content-wrapper">
  <div class="content body">
    """),_display_(/*22.6*/body),format.raw/*22.10*/("""
  """),format.raw/*23.3*/("""</div>
</div>
<script>
$(function()"""),format.raw/*26.13*/("""{"""),format.raw/*26.14*/("""
  """),format.raw/*27.3*/("""$('#filter-box').keyup(function()"""),format.raw/*27.36*/("""{"""),format.raw/*27.37*/("""
    """),format.raw/*28.5*/("""var inputVal = $('#filter-box').val();
    $.each($('li.repo-link a'), function(index, elem) """),format.raw/*29.55*/("""{"""),format.raw/*29.56*/("""
      """),format.raw/*30.7*/("""if ( !inputVal || !elem.text.trim() || elem.text.trim().toLowerCase().indexOf(inputVal.toLowerCase()) >= 0 ) """),format.raw/*30.116*/("""{"""),format.raw/*30.117*/("""
        """),format.raw/*31.9*/("""$(elem).parent().show();
      """),format.raw/*32.7*/("""}"""),format.raw/*32.8*/(""" """),format.raw/*32.9*/("""else """),format.raw/*32.14*/("""{"""),format.raw/*32.15*/("""
        """),format.raw/*33.9*/("""$(elem).parent().hide();
      """),format.raw/*34.7*/("""}"""),format.raw/*34.8*/("""
    """),format.raw/*35.5*/("""}"""),format.raw/*35.6*/(""");
  """),format.raw/*36.3*/("""}"""),format.raw/*36.4*/(""");
  $('form.sidebar-form').submit(function () """),format.raw/*37.45*/("""{"""),format.raw/*37.46*/("""
    """),format.raw/*38.5*/("""return false;
  """),format.raw/*39.3*/("""}"""),format.raw/*39.4*/(""");
"""),format.raw/*40.1*/("""}"""),format.raw/*40.2*/(""");
</script>
"""))
      }
    }
  }

  def render(recentRepositories:List[gitbucket.core.service.RepositoryService.RepositoryInfo],body:Html,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(recentRepositories)(body)(context)

  def f:((List[gitbucket.core.service.RepositoryService.RepositoryInfo]) => (Html) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (recentRepositories) => (body) => (context) => apply(recentRepositories)(body)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/dashboard/sidebar.scala.html
                  HASH: c559e131399b33e0675d07106d2bb6be82666e72
                  MATRIX: 681->1|902->151|965->186|1167->362|1205->363|1238->370|1290->406|1328->407|1362->414|1557->583|1584->601|1610->618|1674->644|1710->653|1796->712|1812->719|1849->735|1879->738|1897->747|1970->798|2000->799|2035->806|2055->816|2083->822|2134->845|2154->855|2181->860|2251->900|2287->906|2317->909|2429->995|2454->999|2484->1002|2547->1037|2576->1038|2606->1041|2667->1074|2696->1075|2728->1080|2849->1173|2878->1174|2912->1181|3050->1290|3080->1291|3116->1300|3174->1331|3202->1332|3230->1333|3263->1338|3292->1339|3328->1348|3386->1379|3414->1380|3446->1385|3474->1386|3506->1391|3534->1392|3609->1439|3638->1440|3670->1445|3713->1461|3741->1462|3771->1465|3799->1466
                  LINES: 14->1|17->2|20->3|24->7|24->7|25->8|26->9|26->9|27->10|28->11|28->11|28->11|28->11|29->12|30->13|30->13|30->13|30->13|30->13|30->13|30->13|30->13|30->13|30->13|30->13|30->13|30->13|32->15|33->16|34->17|39->22|39->22|40->23|43->26|43->26|44->27|44->27|44->27|45->28|46->29|46->29|47->30|47->30|47->30|48->31|49->32|49->32|49->32|49->32|49->32|50->33|51->34|51->34|52->35|52->35|53->36|53->36|54->37|54->37|55->38|56->39|56->39|57->40|57->40
                  -- GENERATED --
              */
          