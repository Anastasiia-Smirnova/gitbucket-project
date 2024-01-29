
package gitbucket.core.pulls.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object proposals extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[Seq[String],gitbucket.core.service.RepositoryService.RepositoryInfo,gitbucket.core.service.RepositoryService.RepositoryInfo,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(branches: Seq[String],
  parent: gitbucket.core.service.RepositoryService.RepositoryInfo,
  repository: gitbucket.core.service.RepositoryService.RepositoryInfo)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*4.2*/import gitbucket.core.view.helpers


Seq[Any](_display_(if(branches.nonEmpty)/*5.23*/{_display_(Seq[Any](format.raw/*5.24*/("""
  """),_display_(/*6.4*/branches/*6.12*/.map/*6.16*/ { branch =>_display_(Seq[Any](format.raw/*6.28*/("""
    """),format.raw/*7.5*/("""<div class="box-content" style="line-height: 20pt; margin-bottom: 6px; padding: 10px 6px 10px 10px; background-color: #fff9ea">
      <strong><i class="menu-icon octicon octicon-git-branch"></i><span class="muted">"""),_display_(/*8.88*/branch),format.raw/*8.94*/("""</span></strong>
      <a class="pull-right btn btn-success" style="position: relative; top: -4px;"
         href=""""),_display_(/*10.17*/helpers/*10.24*/.url(repository)),format.raw/*10.40*/("""/compare/"""),_display_(/*10.50*/{parent.owner}),format.raw/*10.64*/(""":"""),_display_(/*10.66*/{helpers.encodeRefName(parent.repository.defaultBranch)}),format.raw/*10.122*/("""..."""),_display_(/*10.126*/{repository.owner}),format.raw/*10.144*/(""":"""),_display_(/*10.146*/{helpers.encodeRefName(branch)}),format.raw/*10.177*/("""">Compare & pull request</a>
    </div>
  """)))}),format.raw/*12.4*/("""
""")))} else {null} ),format.raw/*13.2*/("""
"""))
      }
    }
  }

  def render(branches:Seq[String],parent:gitbucket.core.service.RepositoryService.RepositoryInfo,repository:gitbucket.core.service.RepositoryService.RepositoryInfo,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(branches,parent,repository)(context)

  def f:((Seq[String],gitbucket.core.service.RepositoryService.RepositoryInfo,gitbucket.core.service.RepositoryService.RepositoryInfo) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (branches,parent,repository) => (context) => apply(branches,parent,repository)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/pulls/proposals.scala.html
                  HASH: b04ffc00d615ccf060747fbb77d44ba16baf9105
                  MATRIX: 736->1|1023->217|1108->274|1146->275|1175->279|1191->287|1203->291|1252->303|1283->308|1524->523|1550->529|1693->645|1709->652|1746->668|1783->678|1818->692|1847->694|1925->750|1957->754|1997->772|2027->774|2080->805|2153->848|2198->850
                  LINES: 14->1|19->4|22->5|22->5|23->6|23->6|23->6|23->6|24->7|25->8|25->8|27->10|27->10|27->10|27->10|27->10|27->10|27->10|27->10|27->10|27->10|27->10|29->12|30->13
                  -- GENERATED --
              */
          