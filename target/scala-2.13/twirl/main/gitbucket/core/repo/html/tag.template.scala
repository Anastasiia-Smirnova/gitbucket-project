
package gitbucket.core.repo.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object tag extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[String,gitbucket.core.service.RepositoryService.RepositoryInfo,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(commitId: String,
  repository: gitbucket.core.service.RepositoryService.RepositoryInfo)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*3.2*/import gitbucket.core.view.helpers


Seq[Any](format.raw/*4.1*/("""<h2 class="facebox-header">
  Add tag
</h2>
<form action=""""),_display_(/*7.16*/helpers/*7.23*/.url(repository)),format.raw/*7.39*/("""/tag" id="tag" method="post" validate="true">
  <fieldset style="margin-top: 20px;">
    <div class="form-group">
      <label class="control-label" for="tagName">Tag name</label>
      <input type="text" id="tagName" name="tagName" class="form-control">
      <span class="error" id="error-tagName"></span>
    </div>
  </fieldset>
  <fieldset>
    <div class="form-group">
      <label class="control-label" for="message">Message</label>
      <input type="text" id="message" name="message" class="form-control">
      <span class="error" id="error-message"></span>
    </div>
  </fieldset>
  <div class="text-right">
    <input type="hidden" name="commitId" value=""""),_display_(/*23.50*/commitId),format.raw/*23.58*/("""">
    <input type="submit" class="btn btn-success" value="Add tag">
  </div>
</form>
"""))
      }
    }
  }

  def render(commitId:String,repository:gitbucket.core.service.RepositoryService.RepositoryInfo,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(commitId,repository)(context)

  def f:((String,gitbucket.core.service.RepositoryService.RepositoryInfo) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (commitId,repository) => (context) => apply(commitId,repository)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/repo/tag.scala.html
                  HASH: bcaad4ed75e4445b136de75383f4a592adfe4ccd
                  MATRIX: 668->1|883->145|946->180|1031->239|1046->246|1082->262|1778->931|1807->939
                  LINES: 14->1|18->3|21->4|24->7|24->7|24->7|40->23|40->23
                  -- GENERATED --
              */
          