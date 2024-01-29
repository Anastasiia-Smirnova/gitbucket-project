
package gitbucket.core.issues.milestones.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object edit extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[Option[gitbucket.core.model.Milestone],gitbucket.core.service.RepositoryService.RepositoryInfo,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(milestone: Option[gitbucket.core.model.Milestone],
  repository: gitbucket.core.service.RepositoryService.RepositoryInfo)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*3.2*/import gitbucket.core.view.helpers


Seq[Any](_display_(/*4.2*/gitbucket/*4.11*/.core.html.main(s"Milestones - ${repository.owner}/${repository.name}")/*4.82*/{_display_(Seq[Any](format.raw/*4.83*/("""
  """),_display_(/*5.4*/gitbucket/*5.13*/.core.html.menu("milestones", repository)/*5.54*/{_display_(Seq[Any](format.raw/*5.55*/("""
    """),_display_(if(milestone.isEmpty)/*6.27*/{_display_(Seq[Any](format.raw/*6.28*/("""
      """),format.raw/*7.7*/("""<h4>New milestone</h4>
      <div class="muted">Create a new milestone to help organize your issues and pull requests.</div>
    """)))} else {null} ),format.raw/*9.6*/("""
    """),format.raw/*10.5*/("""<hr style="margin-top: 12px; margin-bottom: 18px;" class="fill-width"/>
    <form method="POST" action=""""),_display_(/*11.34*/helpers/*11.41*/.url(repository)),format.raw/*11.57*/("""/issues/milestones/"""),_display_(if(milestone.isEmpty)/*11.98*/{_display_(Seq[Any](format.raw/*11.99*/("""new""")))}else/*11.107*/{_display_(Seq[Any](_display_(/*11.109*/milestone/*11.118*/.get.milestoneId),format.raw/*11.134*/("""/edit""")))}),format.raw/*11.140*/("""" validate="true" autocomplete="off">
      <fieldset class="form-group">
        <input type="text" id="title" name="title" class="form-control" style="width: 500px;" value=""""),_display_(/*13.103*/milestone/*13.112*/.map(_.title)),format.raw/*13.125*/("""" placeholder="Title" aria-label="Title"/>
        <span id="error-title" class="error"></span>
      </fieldset>
      <fieldset class="form-group">
        <label for="description" class="strong">Description</label>
        <textarea id="description" name="description" class="form-control" style="width: 500px; height: 150px;">"""),_display_(/*18.114*/milestone/*18.123*/.map(_.description)),format.raw/*18.142*/("""</textarea>
        <span id="error-description" class="error"></span>
      </fieldset>
      <fieldset class="form-group">
        <label for="dueDate" class="strong">Due Date</label>
        """),_display_(/*23.10*/gitbucket/*23.19*/.core.helper.html.datepicker("dueDate", milestone.flatMap(_.dueDate))),format.raw/*23.88*/("""
        """),format.raw/*24.9*/("""<span id="error-dueDate" class="error"></span>
      </fieldset>
      <hr>
      <div class="pull-right">
        """),_display_(if(milestone.isEmpty)/*28.31*/{_display_(Seq[Any](format.raw/*28.32*/("""
          """),format.raw/*29.11*/("""<input type="submit" class="btn btn-success" value="Create milestone"/>
        """)))}else/*30.16*/{_display_(Seq[Any](format.raw/*30.17*/("""
          """),_display_(if(milestone.get.closedDate.isDefined)/*31.50*/{_display_(Seq[Any](format.raw/*31.51*/("""
            """),format.raw/*32.13*/("""<input type="button" class="btn btn-default" value="Open" id="open" onclick="location.href='"""),_display_(/*32.106*/helpers/*32.113*/.url(repository)),format.raw/*32.129*/("""/issues/milestones/"""),_display_(/*32.149*/milestone/*32.158*/.get.milestoneId),format.raw/*32.174*/("""/open';"/>
          """)))}else/*33.18*/{_display_(Seq[Any](format.raw/*33.19*/("""
            """),format.raw/*34.13*/("""<input type="button" class="btn btn-default" value="Close" id="close" onclick="location.href='"""),_display_(/*34.108*/helpers/*34.115*/.url(repository)),format.raw/*34.131*/("""/issues/milestones/"""),_display_(/*34.151*/milestone/*34.160*/.get.milestoneId),format.raw/*34.176*/("""/close';"/>
          """)))}),format.raw/*35.12*/("""
          """),format.raw/*36.11*/("""<input type="submit" class="btn btn-success" value="Update milestone"/>
        """)))}),format.raw/*37.10*/("""
      """),format.raw/*38.7*/("""</div>
    </form>
  """)))}),format.raw/*40.4*/("""
""")))}),format.raw/*41.2*/("""
"""))
      }
    }
  }

  def render(milestone:Option[gitbucket.core.model.Milestone],repository:gitbucket.core.service.RepositoryService.RepositoryInfo,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(milestone,repository)(context)

  def f:((Option[gitbucket.core.model.Milestone],gitbucket.core.service.RepositoryService.RepositoryInfo) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (milestone,repository) => (context) => apply(milestone,repository)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/issues/milestones/edit.scala.html
                  HASH: 24175f11c6893df5ee011af0df2b0462f848c55f
                  MATRIX: 714->1|962->178|1025->214|1042->223|1121->294|1159->295|1188->299|1205->308|1254->349|1292->350|1345->377|1383->378|1416->385|1588->515|1620->520|1752->625|1768->632|1805->648|1873->689|1912->690|1940->698|1980->700|1999->709|2037->725|2075->731|2279->907|2298->916|2333->929|2692->1260|2711->1269|2752->1288|2974->1483|2992->1492|3082->1561|3118->1570|3282->1707|3321->1708|3360->1719|3464->1806|3503->1807|3580->1857|3619->1858|3660->1871|3781->1964|3798->1971|3836->1987|3884->2007|3903->2016|3941->2032|3986->2060|4025->2061|4066->2074|4189->2169|4206->2176|4244->2192|4292->2212|4311->2221|4349->2237|4403->2260|4442->2271|4554->2352|4588->2359|4640->2381|4672->2383
                  LINES: 14->1|18->3|21->4|21->4|21->4|21->4|22->5|22->5|22->5|22->5|23->6|23->6|24->7|26->9|27->10|28->11|28->11|28->11|28->11|28->11|28->11|28->11|28->11|28->11|28->11|30->13|30->13|30->13|35->18|35->18|35->18|40->23|40->23|40->23|41->24|45->28|45->28|46->29|47->30|47->30|48->31|48->31|49->32|49->32|49->32|49->32|49->32|49->32|49->32|50->33|50->33|51->34|51->34|51->34|51->34|51->34|51->34|51->34|52->35|53->36|54->37|55->38|57->40|58->41
                  -- GENERATED --
              */
          