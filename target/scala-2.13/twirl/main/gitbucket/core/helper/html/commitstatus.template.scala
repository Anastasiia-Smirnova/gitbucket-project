
package gitbucket.core.helper.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object commitstatus extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[String,gitbucket.core.model.CommitState,List[gitbucket.core.model.CommitStatus],gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(commitId: String, summary: gitbucket.core.model.CommitState, statuses: List[gitbucket.core.model.CommitStatus])(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*2.2*/import gitbucket.core.view.helpers


Seq[Any](format.raw/*3.1*/("""<strong class="text-"""),_display_(/*3.22*/{summary.name}),format.raw/*3.36*/("""">"""),_display_(/*3.39*/helpers/*3.46*/.commitStateIcon(summary)),format.raw/*3.71*/("""</strong>
<span class="text-"""),_display_(/*4.20*/{summary.name}),format.raw/*4.34*/("""" id="commit-status-"""),_display_(/*4.55*/commitId),format.raw/*4.63*/("""" style="cursor : pointer;">"""),_display_(/*4.92*/{statuses.groupBy(_.state).map { case (keyState, states) => s"${states.size} ${keyState.name}" }.mkString(", ")}),format.raw/*4.204*/(""" """),format.raw/*4.205*/("""checks</span>

<div id="tooltip-commit-status-"""),_display_(/*6.33*/commitId),format.raw/*6.41*/("""" style="display: none; width: 300px;">
"""),_display_(/*7.2*/statuses/*7.10*/.map/*7.14*/{ status =>_display_(Seq[Any](format.raw/*7.25*/("""
  """),format.raw/*8.3*/("""<div class="build-status-item">
    <span class="build-status-icon text-"""),_display_(/*9.42*/{status.state.name}),format.raw/*9.61*/("""">"""),_display_(/*9.64*/helpers/*9.71*/.commitStateIcon(status.state)),format.raw/*9.101*/("""</span>
    <strong>"""),_display_(/*10.14*/status/*10.20*/.context),format.raw/*10.28*/("""</strong>
    """),_display_(/*11.6*/status/*11.12*/.description.map/*11.28*/ { desc =>_display_(Seq[Any](format.raw/*11.38*/(""" """),format.raw/*11.39*/("""<span class="muted">- """),_display_(/*11.62*/desc),format.raw/*11.66*/("""</span> """)))}),format.raw/*11.75*/("""
    """),format.raw/*12.5*/("""<span>"""),_display_(/*12.12*/status/*12.18*/.targetUrl.map/*12.32*/ { url =>_display_(Seq[Any](format.raw/*12.41*/(""" """),format.raw/*12.42*/("""- <a href=""""),_display_(/*12.54*/url),format.raw/*12.57*/("""">Details</a> """)))}),format.raw/*12.72*/("""</span>
  </div>
""")))}),format.raw/*14.2*/("""
"""),format.raw/*15.1*/("""</div>

<script>
$(document).ready(function() """),format.raw/*18.30*/("""{"""),format.raw/*18.31*/("""
  """),format.raw/*19.3*/("""Tipped.create('#commit-status-"""),_display_(/*19.34*/commitId),format.raw/*19.42*/("""', """),format.raw/*19.45*/("""{"""),format.raw/*19.46*/("""
    """),format.raw/*20.5*/("""skin: 'light',
    inline: 'tooltip-commit-status-"""),_display_(/*21.37*/commitId),format.raw/*21.45*/("""',
    size: 'large',
    position: 'bottomleft'
  """),format.raw/*24.3*/("""}"""),format.raw/*24.4*/(""");
"""),format.raw/*25.1*/("""}"""),format.raw/*25.2*/(""");
</script>
"""))
      }
    }
  }

  def render(commitId:String,summary:gitbucket.core.model.CommitState,statuses:List[gitbucket.core.model.CommitStatus],context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(commitId,summary,statuses)(context)

  def f:((String,gitbucket.core.model.CommitState,List[gitbucket.core.model.CommitStatus]) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (commitId,summary,statuses) => (context) => apply(commitId,summary,statuses)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/helper/commitstatus.scala.html
                  HASH: f8a3b2590cb31a760827fdcb33a8506ca39d69cd
                  MATRIX: 696->1|934->168|997->203|1044->224|1078->238|1107->241|1122->248|1167->273|1222->302|1256->316|1303->337|1331->345|1386->374|1519->486|1548->487|1621->534|1649->542|1715->583|1731->591|1743->595|1791->606|1820->609|1919->682|1958->701|1987->704|2002->711|2053->741|2101->762|2116->768|2145->776|2186->791|2201->797|2226->813|2274->823|2303->824|2353->847|2378->851|2418->860|2450->865|2484->872|2499->878|2522->892|2569->901|2598->902|2637->914|2661->917|2707->932|2755->950|2783->951|2857->997|2886->998|2916->1001|2974->1032|3003->1040|3034->1043|3063->1044|3095->1049|3173->1100|3202->1108|3280->1159|3308->1160|3338->1163|3366->1164
                  LINES: 14->1|17->2|20->3|20->3|20->3|20->3|20->3|20->3|21->4|21->4|21->4|21->4|21->4|21->4|21->4|23->6|23->6|24->7|24->7|24->7|24->7|25->8|26->9|26->9|26->9|26->9|26->9|27->10|27->10|27->10|28->11|28->11|28->11|28->11|28->11|28->11|28->11|28->11|29->12|29->12|29->12|29->12|29->12|29->12|29->12|29->12|29->12|31->14|32->15|35->18|35->18|36->19|36->19|36->19|36->19|36->19|37->20|38->21|38->21|41->24|41->24|42->25|42->25
                  -- GENERATED --
              */
          