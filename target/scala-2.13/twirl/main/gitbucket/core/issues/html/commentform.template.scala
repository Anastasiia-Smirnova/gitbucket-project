
package gitbucket.core.issues.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object commentform extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template6[gitbucket.core.model.Issue,Boolean,Boolean,Boolean,gitbucket.core.service.RepositoryService.RepositoryInfo,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(issue: gitbucket.core.model.Issue,
  reopenable: Boolean,
  isEditable: Boolean,
  isManageable: Boolean,
  repository: gitbucket.core.service.RepositoryService.RepositoryInfo)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*6.2*/import gitbucket.core.view.helpers


Seq[Any](_display_(if(isEditable)/*7.16*/{_display_(Seq[Any](format.raw/*7.17*/("""
  """),format.raw/*8.3*/("""<form method="POST" validate="true" autocomplete="off">
    <div class="panel panel-default issue-comment-box">
      <div class="panel-body">
        """),_display_(/*11.10*/gitbucket/*11.19*/.core.helper.html.preview(
          repository         = repository,
          content            = "",
          enableWikiLink     = false,
          enableRefsLink     = true,
          enableLineBreaks   = true,
          enableTaskList     = true,
          hasWritePermission = isEditable,
          completionContext  = "issues",
          style              = "",
          elastic            = true,
          tabIndex           = 1
        )),format.raw/*23.10*/("""
        """),format.raw/*24.9*/("""<div class="text-right">
          <input type="hidden" name="issueId" value=""""),_display_(/*25.55*/issue/*25.60*/.issueId),format.raw/*25.68*/(""""/>
          """),_display_(if((reopenable || !issue.closed) && (isManageable || issue.openedUserName == context.loginAccount.get.userName))/*26.124*/{_display_(Seq[Any](format.raw/*26.125*/("""
            """),format.raw/*27.13*/("""<input type="hidden" id="action" name="action" value="comment"/>
            <div class="btn-group dropup">
              <input type="submit" class="btn btn-success" tabindex="2" formaction=""""),_display_(/*29.86*/helpers/*29.93*/.url(repository)),format.raw/*29.109*/("""/issue_comments/new" value="Comment" id="submit-button"/>
              <button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" aria-label="Select method">
                <span class="caret"></span>
              </button>
            <ul class="dropdown-menu dropdown-menu-right">
              <li><a id="menu-comment">Comment</a></li>
              <li><a id="menu-x-and-comment">"""),_display_(/*35.47*/{if(issue.closed) "Reopen" else "Close"}),format.raw/*35.87*/(""" """),format.raw/*35.88*/("""and comment</a></li>
            </ul>
            </div>
          """)))}else/*38.18*/{_display_(Seq[Any](format.raw/*38.19*/("""
            """),format.raw/*39.13*/("""<input type="submit" class="btn btn-success" tabindex="2" formaction=""""),_display_(/*39.84*/helpers/*39.91*/.url(repository)),format.raw/*39.107*/("""/issue_comments/new" value="Comment"/>
          """)))}),format.raw/*40.12*/("""
        """),format.raw/*41.9*/("""</div>
      </div>
    </div>
  </form>
""")))} else {null} ),format.raw/*45.2*/("""
"""),format.raw/*46.1*/("""<script>
$(function()"""),format.raw/*47.13*/("""{"""),format.raw/*47.14*/("""
  """),format.raw/*48.3*/("""$('#menu-comment').click(function()"""),format.raw/*48.38*/("""{"""),format.raw/*48.39*/("""
    """),format.raw/*49.5*/("""$('#submit-button').attr('value', 'Comment').attr('formaction', '"""),_display_(/*49.71*/helpers/*49.78*/.url(repository)),format.raw/*49.94*/("""/issue_comments/new');
    $('#action').val('comment');
  """),format.raw/*51.3*/("""}"""),format.raw/*51.4*/(""");
  $('#menu-x-and-comment').click(function()"""),format.raw/*52.44*/("""{"""),format.raw/*52.45*/("""
    """),format.raw/*53.5*/("""$('#submit-button').attr('value', '"""),_display_(/*53.41*/{if(issue.closed) "Reopen" else "Close"}),format.raw/*53.81*/(""" """),format.raw/*53.82*/("""and comment').attr('formaction', '"""),_display_(/*53.117*/helpers/*53.124*/.url(repository)),format.raw/*53.140*/("""/issue_comments/state');
    $('#action').val('"""),_display_(/*54.24*/{if(issue.closed) "reopen" else "close"}),format.raw/*54.64*/("""');
  """),format.raw/*55.3*/("""}"""),format.raw/*55.4*/(""");
"""),format.raw/*56.1*/("""}"""),format.raw/*56.2*/(""");
</script>
"""))
      }
    }
  }

  def render(issue:gitbucket.core.model.Issue,reopenable:Boolean,isEditable:Boolean,isManageable:Boolean,repository:gitbucket.core.service.RepositoryService.RepositoryInfo,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(issue,reopenable,isEditable,isManageable,repository)(context)

  def f:((gitbucket.core.model.Issue,Boolean,Boolean,Boolean,gitbucket.core.service.RepositoryService.RepositoryInfo) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (issue,reopenable,isEditable,isManageable,repository) => (context) => apply(issue,reopenable,isEditable,isManageable,repository)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/issues/commentform.scala.html
                  HASH: 31c7f6081366dafd91f42b80b795e72b8c7c2e34
                  MATRIX: 722->1|1025->233|1103->283|1141->284|1170->287|1349->439|1367->448|1840->900|1876->909|1982->988|1996->993|2025->1001|2180->1128|2220->1129|2261->1142|2481->1335|2497->1342|2535->1358|3019->1815|3080->1855|3109->1856|3201->1931|3240->1932|3281->1945|3379->2016|3395->2023|3433->2039|3514->2089|3550->2098|3635->2140|3663->2141|3712->2162|3741->2163|3771->2166|3834->2201|3863->2202|3895->2207|3988->2273|4004->2280|4041->2296|4126->2354|4154->2355|4228->2401|4257->2402|4289->2407|4352->2443|4413->2483|4442->2484|4505->2519|4522->2526|4560->2542|4635->2590|4696->2630|4729->2636|4757->2637|4787->2640|4815->2641
                  LINES: 14->1|21->6|24->7|24->7|25->8|28->11|28->11|40->23|41->24|42->25|42->25|42->25|43->26|43->26|44->27|46->29|46->29|46->29|52->35|52->35|52->35|55->38|55->38|56->39|56->39|56->39|56->39|57->40|58->41|62->45|63->46|64->47|64->47|65->48|65->48|65->48|66->49|66->49|66->49|66->49|68->51|68->51|69->52|69->52|70->53|70->53|70->53|70->53|70->53|70->53|70->53|71->54|71->54|72->55|72->55|73->56|73->56
                  -- GENERATED --
              */
          