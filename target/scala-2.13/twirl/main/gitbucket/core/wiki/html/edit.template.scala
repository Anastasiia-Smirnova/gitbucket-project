
package gitbucket.core.wiki.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object edit extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[String,Option[gitbucket.core.service.WikiService.WikiPageInfo],gitbucket.core.service.RepositoryService.RepositoryInfo,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(pageName: String,
  page: Option[gitbucket.core.service.WikiService.WikiPageInfo],
  repository: gitbucket.core.service.RepositoryService.RepositoryInfo)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*4.2*/import gitbucket.core.view.helpers
/*5.2*/import gitbucket.core.util.FileUtil


Seq[Any](_display_(/*6.2*/gitbucket/*6.11*/.core.html.main(s"${if(pageName.isEmpty) "New Page" else pageName} - ${repository.owner}/${repository.name}", Some(repository))/*6.138*/{_display_(Seq[Any](format.raw/*6.139*/("""
  """),_display_(/*7.4*/gitbucket/*7.13*/.core.html.menu("wiki", repository)/*7.48*/{_display_(Seq[Any](format.raw/*7.49*/("""
    """),format.raw/*8.5*/("""<div class="pull-right">
      """),_display_(if(page.isDefined)/*9.26*/{_display_(Seq[Any](format.raw/*9.27*/("""
        """),format.raw/*10.9*/("""<a class="btn btn-default" href=""""),_display_(/*10.43*/helpers/*10.50*/.url(repository)),format.raw/*10.66*/("""/wiki/"""),_display_(/*10.73*/helpers/*10.80*/.urlEncode(pageName)),format.raw/*10.100*/("""/_history">Page History</a>
        <a class="btn btn-danger" href=""""),_display_(/*11.42*/helpers/*11.49*/.url(repository)),format.raw/*11.65*/("""/wiki/"""),_display_(/*11.72*/helpers/*11.79*/.urlEncode(pageName)),format.raw/*11.99*/("""/_delete" id="delete">Delete Page</a>
      """)))} else {null} ),format.raw/*12.8*/("""
    """),format.raw/*13.5*/("""</div>
    <h1 class="body-title"><span class="muted">Editing</span> """),_display_(if(pageName.isEmpty)/*14.84*/{_display_(Seq[Any](format.raw/*14.85*/("""New Page""")))}else/*14.100*/{_display_(_display_(/*14.102*/pageName))}),format.raw/*14.111*/("""</h1>
    <form action=""""),_display_(/*15.20*/helpers/*15.27*/.url(repository)),format.raw/*15.43*/("""/wiki/"""),_display_(if(page.isEmpty)/*15.66*/{_display_(Seq[Any](format.raw/*15.67*/("""_new""")))}else/*15.78*/{_display_(Seq[Any](format.raw/*15.79*/("""_edit""")))}),format.raw/*15.85*/("""" method="POST" validate="true" autocomplete="off">
      <span id="error-pageName" class="error"></span>
      <input type="text" name="pageName" value=""""),_display_(/*17.50*/pageName),format.raw/*17.58*/("""" class="form-control" style="font-weight: bold; margin-bottom: 10px;" placeholder="Input a page name." aria-label="Page name"/>
      <div class="muted attachable">
        """),_display_(/*19.10*/gitbucket/*19.19*/.core.helper.html.preview(
          repository         = repository,
          content            = page.map(_.content).getOrElse(""),
          enableWikiLink     = true,
          enableRefsLink     = false,
          enableLineBreaks   = false,
          enableTaskList     = false,
          hasWritePermission = false,
          completionContext  = "wiki",
          style              = "height: 400px;",
          styleClass         = "monospace",
          placeholder        = "",
          ariaLabel          = "Page content",
          uid                = 1
        )),format.raw/*33.10*/("""
      """),format.raw/*34.7*/("""</div>
      <div class="form-group">
        <label for="message">Edit Message</label>
        <input type="text" id="message" name="message" value="" class="form-control" placeholder="(Optional) Write a summary of this edit."/>
      </div>
      <div class="form-group pull-right">
        <input type="hidden" name="currentPageName" value=""""),_display_(/*40.61*/pageName),format.raw/*40.69*/(""""/>
        <input type="hidden" name="id" value=""""),_display_(/*41.48*/page/*41.52*/.map(_.id)),format.raw/*41.62*/(""""/>
        <input type="submit" value="Save" class="btn btn-success">
      </div>
    </form>
  """)))}),format.raw/*45.4*/("""
""")))}),format.raw/*46.2*/("""
"""),format.raw/*47.1*/("""<script>
$(function()"""),format.raw/*48.13*/("""{"""),format.raw/*48.14*/("""
  """),format.raw/*49.3*/("""try """),format.raw/*49.7*/("""{"""),format.raw/*49.8*/("""
    """),format.raw/*50.5*/("""$('#content1').dropzone("""),format.raw/*50.29*/("""{"""),format.raw/*50.30*/("""
      """),format.raw/*51.7*/("""url: '"""),_display_(/*51.14*/context/*51.21*/.path),format.raw/*51.26*/("""/upload/wiki/"""),_display_(/*51.40*/repository/*51.50*/.owner),format.raw/*51.56*/("""/"""),_display_(/*51.58*/repository/*51.68*/.name),format.raw/*51.73*/("""',
      maxFilesize: """),_display_(/*52.21*/{context.settings.upload.maxFileSize / 1024 / 1024}),format.raw/*52.72*/(""",
      timeout: """),_display_(/*53.17*/{context.settings.upload.timeout}),format.raw/*53.50*/(""",
      clickable: false,
      previewTemplate: "<div class=\"dz-preview\">\n  <div class=\"dz-progress\"><span class=\"dz-upload\" data-dz-uploadprogress>Uploading your files...</span></div>\n  <div class=\"dz-error-message\"><span data-dz-errormessage></span></div>\n</div>",
      success: function(file, id) """),format.raw/*56.35*/("""{"""),format.raw/*56.36*/("""
        """),format.raw/*57.9*/("""var attachFile = (file.type.match(/image\/.*/) ? '\n![' + file.name.split('.')[0] : '\n[' + file.name) + '](' + file.name + ')';
        $('#content1').val($('#content1').val() + attachFile);
        $(file.previewElement).prevAll('div.dz-preview').addBack().remove();
      """),format.raw/*60.7*/("""}"""),format.raw/*60.8*/("""
    """),format.raw/*61.5*/("""}"""),format.raw/*61.6*/(""");
    $('.clickable').dropzone("""),format.raw/*62.30*/("""{"""),format.raw/*62.31*/("""
      """),format.raw/*63.7*/("""url: '"""),_display_(/*63.14*/context/*63.21*/.path),format.raw/*63.26*/("""/upload/wiki/"""),_display_(/*63.40*/repository/*63.50*/.owner),format.raw/*63.56*/("""/"""),_display_(/*63.58*/repository/*63.68*/.name),format.raw/*63.73*/("""',
      maxFilesize: """),_display_(/*64.21*/{context.settings.upload.maxFileSize / 1024 / 1024}),format.raw/*64.72*/(""",
      timeout: """),_display_(/*65.17*/{context.settings.upload.timeout}),format.raw/*65.50*/(""",
      previewTemplate: "<div class=\"dz-preview\">\n  <div class=\"dz-progress\"><span class=\"dz-upload\" data-dz-uploadprogress>Uploading your files...</span></div>\n  <div class=\"dz-error-message\"><span data-dz-errormessage></span></div>\n</div>",
      success: function(file, id) """),format.raw/*67.35*/("""{"""),format.raw/*67.36*/("""
        """),format.raw/*68.9*/("""var attachFile = (file.type.match(/image\/.*/) ? '\n![' + file.name.split('.')[0] : '\n[' + file.name) + '](' + file.name + ')';
        $('#content1').val($('#content1').val() + attachFile);
        $(file.previewElement).prevAll('div.dz-preview').addBack().remove();
      """),format.raw/*71.7*/("""}"""),format.raw/*71.8*/("""
    """),format.raw/*72.5*/("""}"""),format.raw/*72.6*/(""");
  """),format.raw/*73.3*/("""}"""),format.raw/*73.4*/(""" """),format.raw/*73.5*/("""catch(e) """),format.raw/*73.14*/("""{"""),format.raw/*73.15*/("""
    """),format.raw/*74.5*/("""if (e.message !== "Dropzone already attached.") """),format.raw/*74.53*/("""{"""),format.raw/*74.54*/("""
      """),format.raw/*75.7*/("""throw e;
    """),format.raw/*76.5*/("""}"""),format.raw/*76.6*/("""
  """),format.raw/*77.3*/("""}"""),format.raw/*77.4*/("""

  """),format.raw/*79.3*/("""$('#delete').click(function()"""),format.raw/*79.32*/("""{"""),format.raw/*79.33*/("""
    """),format.raw/*80.5*/("""return confirm('Are you sure you want to delete this page?');
  """),format.raw/*81.3*/("""}"""),format.raw/*81.4*/(""");
"""),format.raw/*82.1*/("""}"""),format.raw/*82.2*/(""");
</script>
"""))
      }
    }
  }

  def render(pageName:String,page:Option[gitbucket.core.service.WikiService.WikiPageInfo],repository:gitbucket.core.service.RepositoryService.RepositoryInfo,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(pageName,page,repository)(context)

  def f:((String,Option[gitbucket.core.service.WikiService.WikiPageInfo],gitbucket.core.service.RepositoryService.RepositoryInfo) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (pageName,page,repository) => (context) => apply(pageName,page,repository)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/wiki/edit.scala.html
                  HASH: 5ba6ec6b3fb2610a5b235708bb61b06ab1980975
                  MATRIX: 725->1|1005->210|1047->246|1111->283|1128->292|1264->419|1303->420|1332->424|1349->433|1392->468|1430->469|1461->474|1537->524|1575->525|1611->534|1672->568|1688->575|1725->591|1759->598|1775->605|1817->625|1913->694|1929->701|1966->717|2000->724|2016->731|2057->751|2145->796|2177->801|2294->891|2333->892|2366->907|2397->909|2430->918|2482->943|2498->950|2535->966|2585->989|2624->990|2652->1001|2691->1002|2728->1008|2910->1163|2939->1171|3141->1346|3159->1355|3761->1936|3795->1943|4167->2288|4196->2296|4274->2347|4287->2351|4318->2361|4447->2460|4479->2462|4507->2463|4556->2484|4585->2485|4615->2488|4646->2492|4674->2493|4706->2498|4758->2522|4787->2523|4821->2530|4855->2537|4871->2544|4897->2549|4938->2563|4957->2573|4984->2579|5013->2581|5032->2591|5058->2596|5108->2619|5180->2670|5225->2688|5279->2721|5620->3034|5649->3035|5685->3044|5987->3319|6015->3320|6047->3325|6075->3326|6135->3358|6164->3359|6198->3366|6232->3373|6248->3380|6274->3385|6315->3399|6334->3409|6361->3415|6390->3417|6409->3427|6435->3432|6485->3455|6557->3506|6602->3524|6656->3557|6973->3846|7002->3847|7038->3856|7340->4131|7368->4132|7400->4137|7428->4138|7460->4143|7488->4144|7516->4145|7553->4154|7582->4155|7614->4160|7690->4208|7719->4209|7753->4216|7793->4229|7821->4230|7851->4233|7879->4234|7910->4238|7967->4267|7996->4268|8028->4273|8119->4337|8147->4338|8177->4341|8205->4342
                  LINES: 14->1|19->4|20->5|23->6|23->6|23->6|23->6|24->7|24->7|24->7|24->7|25->8|26->9|26->9|27->10|27->10|27->10|27->10|27->10|27->10|27->10|28->11|28->11|28->11|28->11|28->11|28->11|29->12|30->13|31->14|31->14|31->14|31->14|31->14|32->15|32->15|32->15|32->15|32->15|32->15|32->15|32->15|34->17|34->17|36->19|36->19|50->33|51->34|57->40|57->40|58->41|58->41|58->41|62->45|63->46|64->47|65->48|65->48|66->49|66->49|66->49|67->50|67->50|67->50|68->51|68->51|68->51|68->51|68->51|68->51|68->51|68->51|68->51|68->51|69->52|69->52|70->53|70->53|73->56|73->56|74->57|77->60|77->60|78->61|78->61|79->62|79->62|80->63|80->63|80->63|80->63|80->63|80->63|80->63|80->63|80->63|80->63|81->64|81->64|82->65|82->65|84->67|84->67|85->68|88->71|88->71|89->72|89->72|90->73|90->73|90->73|90->73|90->73|91->74|91->74|91->74|92->75|93->76|93->76|94->77|94->77|96->79|96->79|96->79|97->80|98->81|98->81|99->82|99->82
                  -- GENERATED --
              */
          