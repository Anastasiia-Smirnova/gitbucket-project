
package gitbucket.core.helper.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object commitcomment extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template5[gitbucket.core.model.CommitComment,Boolean,gitbucket.core.service.RepositoryService.RepositoryInfo,Option[String],gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(comment: gitbucket.core.model.CommitComment,
  hasWritePermission: Boolean,
  repository: gitbucket.core.service.RepositoryService.RepositoryInfo,
  latestCommitId: Option[String] = None)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*5.2*/import gitbucket.core.view.helpers


Seq[Any](format.raw/*6.1*/("""<div class="commit-comment-box """),_display_(if(latestCommitId.contains(comment.commitId))/*6.78*/{_display_(Seq[Any](format.raw/*6.79*/("""inline-comment""")))} else {null} ),format.raw/*6.94*/("""" id="discussion_r"""),_display_(/*6.113*/comment/*6.120*/.commentId),format.raw/*6.130*/(""""
  """),_display_(if(comment.fileName.isDefined)/*7.34*/{_display_(Seq[Any](format.raw/*7.35*/("""filename=""""),_display_(/*7.46*/comment/*7.53*/.fileName.get),format.raw/*7.66*/(""""""")))} else {null} ),format.raw/*7.68*/("""
  """),_display_(if(comment.newLine.isDefined)/*8.33*/{_display_(Seq[Any](format.raw/*8.34*/("""newline=""""),_display_(/*8.44*/comment/*8.51*/.newLine.get),format.raw/*8.63*/(""""""")))} else {null} ),format.raw/*8.65*/("""
  """),_display_(if(comment.oldLine.isDefined)/*9.33*/{_display_(Seq[Any](format.raw/*9.34*/("""oldline=""""),_display_(/*9.44*/comment/*9.51*/.oldLine.get),format.raw/*9.63*/(""""""")))} else {null} ),format.raw/*9.65*/(""">
  <div class="commit-comment-"""),_display_(/*10.31*/comment/*10.38*/.commentId),format.raw/*10.48*/("""">
    <div class="markdown-body">
      <div>
        """),_display_(/*13.10*/helpers/*13.17*/.avatarLink(comment.commentedUserName, 20)),format.raw/*13.59*/("""
        """),_display_(/*14.10*/helpers/*14.17*/.user(comment.commentedUserName, styleClass="username strong")),format.raw/*14.79*/("""
        """),format.raw/*15.9*/("""<span class="muted">"""),_display_(/*15.30*/gitbucket/*15.39*/.core.helper.html.datetimeago(comment.registeredDate)),format.raw/*15.92*/("""</span>
        <span class="pull-right">
        """),_display_(if(hasWritePermission || context.loginAccount.map(_.userName == comment.commentedUserName).getOrElse(false))/*17.118*/{_display_(Seq[Any](format.raw/*17.119*/("""
          """),format.raw/*18.11*/("""<a href="#" data-comment-id=""""),_display_(/*18.41*/comment/*18.48*/.commentId),format.raw/*18.58*/(""""><i class="octicon octicon-pencil" aria-label="Edit"></i></a>&nbsp;
          <a href="#" data-comment-id=""""),_display_(/*19.41*/comment/*19.48*/.commentId),format.raw/*19.58*/(""""><i class="octicon octicon-x" aria-label="Remove"></i></a>
        """)))} else {null} ),format.raw/*20.10*/("""
        """),format.raw/*21.9*/("""</span>
      </div>
      <div class="commit-commentContent-"""),_display_(/*23.42*/comment/*23.49*/.commentId),format.raw/*23.59*/("""">
        """),_display_(/*24.10*/helpers/*24.17*/.markdown(
          markdown           = comment.content,
          repository         = repository,
          branch             = repository.repository.defaultBranch,
          enableWikiLink     = false,
          enableRefsLink     = true,
          enableLineBreaks   = true,
          enableTaskList     = true,
          hasWritePermission = hasWritePermission
        )),format.raw/*33.10*/("""
      """),format.raw/*34.7*/("""</div>
    </div>
  </div>
</div>
"""))
      }
    }
  }

  def render(comment:gitbucket.core.model.CommitComment,hasWritePermission:Boolean,repository:gitbucket.core.service.RepositoryService.RepositoryInfo,latestCommitId:Option[String],context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(comment,hasWritePermission,repository,latestCommitId)(context)

  def f:((gitbucket.core.model.CommitComment,Boolean,gitbucket.core.service.RepositoryService.RepositoryInfo,Option[String]) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (comment,hasWritePermission,repository,latestCommitId) => (context) => apply(comment,hasWritePermission,repository,latestCommitId)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/helper/commitcomment.scala.html
                  HASH: 6c423e565de9ce7d40f36594b3ccbcf19262008b
                  MATRIX: 731->1|1045->244|1108->279|1211->356|1249->357|1307->372|1353->391|1369->398|1400->408|1461->443|1499->444|1536->455|1551->462|1584->475|1629->477|1688->510|1726->511|1762->521|1777->528|1809->540|1854->542|1913->575|1951->576|1987->586|2002->593|2034->605|2079->607|2138->639|2154->646|2185->656|2268->712|2284->719|2347->761|2384->771|2400->778|2483->840|2519->849|2567->870|2585->879|2659->932|2846->1091|2886->1092|2925->1103|2982->1133|2998->1140|3029->1150|3165->1259|3181->1266|3212->1276|3325->1345|3361->1354|3450->1416|3466->1423|3497->1433|3536->1445|3552->1452|3951->1830|3985->1837
                  LINES: 14->1|20->5|23->6|23->6|23->6|23->6|23->6|23->6|23->6|24->7|24->7|24->7|24->7|24->7|24->7|25->8|25->8|25->8|25->8|25->8|25->8|26->9|26->9|26->9|26->9|26->9|26->9|27->10|27->10|27->10|30->13|30->13|30->13|31->14|31->14|31->14|32->15|32->15|32->15|32->15|34->17|34->17|35->18|35->18|35->18|35->18|36->19|36->19|36->19|37->20|38->21|40->23|40->23|40->23|41->24|41->24|50->33|51->34
                  -- GENERATED --
              */
          