
package gitbucket.core.helper.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object commitcomments extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template5[gitbucket.core.model.CommitComments,Boolean,gitbucket.core.service.RepositoryService.RepositoryInfo,Option[String],gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(comments: gitbucket.core.model.CommitComments,
  hasWritePermission: Boolean,
  repository: gitbucket.core.service.RepositoryService.RepositoryInfo,
  latestCommitId: Option[String] = None)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*5.2*/import gitbucket.core.view.helpers


Seq[Any](format.raw/*6.1*/("""<div class="panel panel-default">
  <div class="panel-heading">
    <span class="monospace">"""),_display_(/*8.30*/comments/*8.38*/.fileName),format.raw/*8.47*/("""</span>
    """),_display_(if(!latestCommitId.contains(comments.comments.head.commitId))/*9.67*/ {_display_(Seq[Any](format.raw/*9.69*/("""
      """),format.raw/*10.7*/("""<span class="pull-right"><a href="javascript:void(0);" onclick="$('.fold-comments-"""),_display_(/*10.90*/comments/*10.98*/.comments.head.commentId),format.raw/*10.122*/("""').toggle();"><i class="octicon octicon-unfold"></i></a></span>
    """)))} else {null} ),format.raw/*11.6*/("""
  """),format.raw/*12.3*/("""</div>
  <div style=""""),_display_(if(!latestCommitId.contains(comments.comments.head.commitId))/*13.77*/{_display_(Seq[Any](format.raw/*13.78*/("""display: none;""")))} else {null} ),format.raw/*13.93*/("""" class="fold-comments-"""),_display_(/*13.117*/comments/*13.125*/.comments.head.commentId),format.raw/*13.149*/("""">
    """),_display_(/*14.6*/comments/*14.14*/.diff.map(helpers.diff)),format.raw/*14.37*/("""
    """),format.raw/*15.5*/("""<div class="panel-body">
    """),_display_(/*16.6*/comments/*16.14*/.comments.map/*16.27*/ { comment =>_display_(Seq[Any](format.raw/*16.40*/("""
      """),_display_(/*17.8*/gitbucket/*17.17*/.core.helper.html.commitcomment(comment, hasWritePermission, repository, latestCommitId)),format.raw/*17.105*/("""
    """)))}),format.raw/*18.6*/("""
    """),format.raw/*19.5*/("""</div>
  </div>
</div>

"""),_display_(if(!latestCommitId.contains(comments.comments.head.commitId))/*23.63*/ {_display_(Seq[Any](format.raw/*23.65*/("""
  """),format.raw/*24.3*/("""<script>
    $(function()"""),format.raw/*25.17*/("""{"""),format.raw/*25.18*/("""
      """),format.raw/*26.7*/("""var foldComments = $('.fold-comments-"""),_display_(/*26.45*/comments/*26.53*/.comments.head.commentId),format.raw/*26.77*/("""');
      if(foldComments.find('input:checkbox:not(:checked)').length > 0)"""),format.raw/*27.71*/("""{"""),format.raw/*27.72*/("""
        """),format.raw/*28.9*/("""foldComments.show();
      """),format.raw/*29.7*/("""}"""),format.raw/*29.8*/("""
    """),format.raw/*30.5*/("""}"""),format.raw/*30.6*/(""");
  </script>
""")))} else {null} ),format.raw/*32.2*/("""
"""))
      }
    }
  }

  def render(comments:gitbucket.core.model.CommitComments,hasWritePermission:Boolean,repository:gitbucket.core.service.RepositoryService.RepositoryInfo,latestCommitId:Option[String],context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(comments,hasWritePermission,repository,latestCommitId)(context)

  def f:((gitbucket.core.model.CommitComments,Boolean,gitbucket.core.service.RepositoryService.RepositoryInfo,Option[String]) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (comments,hasWritePermission,repository,latestCommitId) => (context) => apply(comments,hasWritePermission,repository,latestCommitId)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/helper/commitcomments.scala.html
                  HASH: 086ebe415afada4d979ee6556f03281788ab50d4
                  MATRIX: 733->1|1049->246|1112->281|1231->374|1247->382|1276->391|1376->465|1415->467|1449->474|1559->557|1576->565|1622->589|1734->658|1764->661|1874->744|1913->745|1972->760|2024->784|2042->792|2088->816|2122->824|2139->832|2183->855|2215->860|2271->890|2288->898|2310->911|2361->924|2395->932|2413->941|2523->1029|2559->1035|2591->1040|2704->1126|2744->1128|2774->1131|2827->1156|2856->1157|2890->1164|2955->1202|2972->1210|3017->1234|3119->1308|3148->1309|3184->1318|3238->1345|3266->1346|3298->1351|3326->1352|3385->1368
                  LINES: 14->1|20->5|23->6|25->8|25->8|25->8|26->9|26->9|27->10|27->10|27->10|27->10|28->11|29->12|30->13|30->13|30->13|30->13|30->13|30->13|31->14|31->14|31->14|32->15|33->16|33->16|33->16|33->16|34->17|34->17|34->17|35->18|36->19|40->23|40->23|41->24|42->25|42->25|43->26|43->26|43->26|43->26|44->27|44->27|45->28|46->29|46->29|47->30|47->30|49->32
                  -- GENERATED --
              */
          