
package gitbucket.core.releases.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object form extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template6[gitbucket.core.service.RepositoryService.RepositoryInfo,gitbucket.core.util.JGitUtil.TagInfo,Seq[String],String,Option[(gitbucket.core.model.ReleaseTag, Seq[gitbucket.core.model.ReleaseAsset])],gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(repository: gitbucket.core.service.RepositoryService.RepositoryInfo,
  tag: gitbucket.core.util.JGitUtil.TagInfo,
  tags: Seq[String],
  content: String,
  release: Option[(gitbucket.core.model.ReleaseTag, Seq[gitbucket.core.model.ReleaseAsset])])(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*6.2*/import gitbucket.core.view.helpers


Seq[Any](_display_(/*7.2*/gitbucket/*7.11*/.core.html.main(s"New Release - ${repository.owner}/${repository.name}", Some(repository))/*7.101*/{_display_(Seq[Any](format.raw/*7.102*/("""
  """),_display_(/*8.4*/gitbucket/*8.13*/.core.html.menu("releases", repository)/*8.52*/{_display_(Seq[Any](format.raw/*8.53*/("""
    """),format.raw/*9.5*/("""<form method="POST" validate="true" class="form-group" autocomplete="off">
      <div class="row-fluid">
        <div class="co`l-md-12">
          """),_display_(if(release.isEmpty)/*12.31*/{_display_(Seq[Any](format.raw/*12.32*/("""
            """),format.raw/*13.13*/("""<h3>New release for """),_display_(/*13.34*/tag/*13.37*/.name),format.raw/*13.42*/("""</h3>
          """)))}else/*14.18*/{_display_(Seq[Any](format.raw/*14.19*/("""
            """),format.raw/*15.13*/("""<h3>Update release for """),_display_(/*15.37*/tag/*15.40*/.name),format.raw/*15.45*/("""</h3>
          """)))}),format.raw/*16.12*/("""
          """),format.raw/*17.11*/("""<span id="error-name" class="error"></span>
          <input type="text" id="release-name" name="name" class="form-control" value=""""),_display_(/*18.89*/(release.map { case (release, _) => release.name }.getOrElse(tag.name))),format.raw/*18.160*/("""" placeholder="Title" style="margin-bottom: 6px;" autofocus aria-label="Release name"/>
          <div class="pull-right">
            <label for="insert-changelog-tag">Previous tag: </label>
            <select id="insert-changelog-tag">
              """),_display_(/*22.16*/tags/*22.20*/.map/*22.24*/ { tag =>_display_(Seq[Any](format.raw/*22.33*/("""
                """),format.raw/*23.17*/("""<option value=""""),_display_(/*23.33*/tag),format.raw/*23.36*/("""">"""),_display_(/*23.39*/tag),format.raw/*23.42*/("""</option>
              """)))}),format.raw/*24.16*/("""
              """),format.raw/*25.15*/("""<option value="">None</option>
            </select>
            <input id="insert-changelog-button" type="button" value="Insert ChangeLog"/>
          </div>
          """),_display_(/*29.12*/gitbucket/*29.21*/.core.helper.html.preview(
            repository         = repository,
            content            = content,
            enableWikiLink     = false,
            enableRefsLink     = true,
            enableLineBreaks   = true,
            enableTaskList     = true,
            hasWritePermission = true,
            completionContext  = "releases",
            style              = "height: 200px; max-height: 500px;",
            elastic            = true,
            placeholder        = "Describe this release",
            ariaLabel          = "Release content"
          )),format.raw/*42.12*/("""
          """),format.raw/*43.11*/("""<ul id="assets-list" class="collaborator">
            """),_display_(/*44.14*/release/*44.21*/.map/*44.25*/ { case (release, assets) =>_display_(Seq[Any](format.raw/*44.53*/("""
              """),_display_(/*45.16*/assets/*45.22*/.map/*45.26*/ { asset =>_display_(Seq[Any](format.raw/*45.37*/("""
                """),format.raw/*46.17*/("""<li>
                  <a href=""""),_display_(/*47.29*/context/*47.36*/.baseUrl),format.raw/*47.44*/("""/"""),_display_(/*47.46*/repository/*47.56*/.owner),format.raw/*47.62*/("""/"""),_display_(/*47.64*/repository/*47.74*/.name),format.raw/*47.79*/("""/_release/"""),_display_(/*47.90*/helpers/*47.97*/.urlEncode(tag.name)),format.raw/*47.117*/("""/"""),_display_(/*47.119*/asset/*47.124*/.fileName),format.raw/*47.133*/(""""><i class="octicon octicon-file"></i>"""),_display_(/*47.172*/asset/*47.177*/.label),format.raw/*47.183*/("""</a>
                  <a href="#" class="remove pull-right" style="padding-top: 0px;">(remove)</a>
                  <input type="hidden" name="file:"""),_display_(/*49.52*/asset/*49.57*/.fileName),format.raw/*49.66*/("""" value=""""),_display_(/*49.76*/asset/*49.81*/.label),format.raw/*49.87*/(""""/>
                </li>
              """)))}),format.raw/*51.16*/("""
            """)))}),format.raw/*52.14*/("""
          """),format.raw/*53.11*/("""</ul>
          <div style="border: 1px dashed #ccc; color: gray; background-color: #eee; padding: 4px;">
            <div id="drop" class="clickable">Attach release files by dragging &amp; dropping, or selecting them.</div>
          </div>
          <div class="align-right" style="margin-top: 12px;">
            """),_display_(if(release.isEmpty)/*58.33*/{_display_(Seq[Any](format.raw/*58.34*/("""
              """),format.raw/*59.15*/("""<input type="submit" class="btn btn-success" value="Submit new release" formaction=""""),_display_(/*59.100*/helpers/*59.107*/.url(repository)),format.raw/*59.123*/("""/releases/"""),_display_(/*59.134*/helpers/*59.141*/.urlEncode(tag.name)),format.raw/*59.161*/("""/create"/>
            """)))}else/*60.20*/{_display_(Seq[Any](format.raw/*60.21*/("""
              """),format.raw/*61.15*/("""<input type="submit" class="btn btn-success" value="Update release" formaction=""""),_display_(/*61.96*/helpers/*61.103*/.url(repository)),format.raw/*61.119*/("""/releases/"""),_display_(/*61.130*/helpers/*61.137*/.urlEncode(tag.name)),format.raw/*61.157*/("""/edit"/>
            """)))}),format.raw/*62.14*/("""
          """),format.raw/*63.11*/("""</div>
        </div>
      </div>
    </form>
  """)))}),format.raw/*67.4*/("""
""")))}),format.raw/*68.2*/("""
"""),format.raw/*69.1*/("""<script>
$(function()"""),format.raw/*70.13*/("""{"""),format.raw/*70.14*/("""
  """),format.raw/*71.3*/("""$(document).on('click', '.remove', function()"""),format.raw/*71.48*/("""{"""),format.raw/*71.49*/("""
    """),format.raw/*72.5*/("""$(this).parent().remove();
  """),format.raw/*73.3*/("""}"""),format.raw/*73.4*/(""");

  $("#drop").dropzone("""),format.raw/*75.23*/("""{"""),format.raw/*75.24*/("""
    """),format.raw/*76.5*/("""url: '"""),_display_(/*76.12*/context/*76.19*/.path),format.raw/*76.24*/("""/upload/release/"""),_display_(/*76.41*/repository/*76.51*/.owner),format.raw/*76.57*/("""/"""),_display_(/*76.59*/repository/*76.69*/.name),format.raw/*76.74*/("""/"""),_display_(/*76.76*/helpers/*76.83*/.encodeRefName(tag.name)),format.raw/*76.107*/("""',
    maxFilesize: """),_display_(/*77.19*/{context.settings.upload.largeMaxFileSize / 1024 / 1024}),format.raw/*77.75*/(""",
    timeout: """),_display_(/*78.15*/{context.settings.upload.largeTimeout}),format.raw/*78.53*/(""",
    previewTemplate: "<div class=\"dz-preview\">\n  <div class=\"dz-progress\"><span class=\"dz-upload\" data-dz-uploadprogress>Uploading your files...</span></div>\n  <div class=\"dz-error-message\"><span data-dz-errormessage></span></div>\n</div>",
    success: function(file, id) """),format.raw/*80.33*/("""{"""),format.raw/*80.34*/("""
      """),format.raw/*81.7*/("""var attach =
        '<li><a href=""""),_display_(/*82.24*/context/*82.31*/.baseUrl),format.raw/*82.39*/("""/"""),_display_(/*82.41*/repository/*82.51*/.owner),format.raw/*82.57*/("""/"""),_display_(/*82.59*/repository/*82.69*/.name),format.raw/*82.74*/("""/_release/"""),_display_(/*82.85*/helpers/*82.92*/.encodeRefName(tag.name)),format.raw/*82.116*/("""/' + id + '">' +
        '<i class="octicon octicon-file"></i>' + escapeHtml(file.name) + '</a>' +
        '<a href="#" class="remove pull-right" style="padding-top: 0px;">(remove)</a>' +
        '<input type="hidden" name="file:' + id + '" value="' + escapeHtml(file.name) + '"/>'
        '</li>';
      $('#assets-list').append(attach);
      $(file.previewElement).prevAll('div.dz-preview').addBack().remove();
    """),format.raw/*89.5*/("""}"""),format.raw/*89.6*/("""
  """),format.raw/*90.3*/("""}"""),format.raw/*90.4*/(""");

  $('#insert-changelog-button').click(function()"""),format.raw/*92.49*/("""{"""),format.raw/*92.50*/("""
    """),format.raw/*93.5*/("""var previousTag = $('#insert-changelog-tag option:selected').val();
    $.get('"""),_display_(/*94.13*/context/*94.20*/.path),format.raw/*94.25*/("""/"""),_display_(/*94.27*/repository/*94.37*/.owner),format.raw/*94.43*/("""/"""),_display_(/*94.45*/repository/*94.55*/.name),format.raw/*94.60*/("""/changelog/' + encodeURIComponent(previousTag) + '..."""),_display_(/*94.114*/helpers/*94.121*/.urlEncode(tag.name)),format.raw/*94.141*/("""', function(data)"""),format.raw/*94.158*/("""{"""),format.raw/*94.159*/("""
      """),format.raw/*95.7*/("""console.log(data);
      var content = $('textarea[name=content]').val();
      if(content == '')"""),format.raw/*97.24*/("""{"""),format.raw/*97.25*/("""
        """),format.raw/*98.9*/("""content = data;
      """),format.raw/*99.7*/("""}"""),format.raw/*99.8*/(""" """),format.raw/*99.9*/("""else """),format.raw/*99.14*/("""{"""),format.raw/*99.15*/("""
        """),format.raw/*100.9*/("""content = content.trimRight() + '\n\n' + data;
      """),format.raw/*101.7*/("""}"""),format.raw/*101.8*/("""
      """),format.raw/*102.7*/("""$('textarea[name=content]').val(content);
    """),format.raw/*103.5*/("""}"""),format.raw/*103.6*/(""");
  """),format.raw/*104.3*/("""}"""),format.raw/*104.4*/(""");
"""),format.raw/*105.1*/("""}"""),format.raw/*105.2*/(""");
</script>
"""))
      }
    }
  }

  def render(repository:gitbucket.core.service.RepositoryService.RepositoryInfo,tag:gitbucket.core.util.JGitUtil.TagInfo,tags:Seq[String],content:String,release:Option[(gitbucket.core.model.ReleaseTag, Seq[gitbucket.core.model.ReleaseAsset])],context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(repository,tag,tags,content,release)(context)

  def f:((gitbucket.core.service.RepositoryService.RepositoryInfo,gitbucket.core.util.JGitUtil.TagInfo,Seq[String],String,Option[(gitbucket.core.model.ReleaseTag, Seq[gitbucket.core.model.ReleaseAsset])]) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (repository,tag,tags,content,release) => (context) => apply(repository,tag,tags,content,release)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/releases/form.scala.html
                  HASH: e119419bfea44255d2c5733895efacc7acb293c9
                  MATRIX: 804->1|1178->304|1241->340|1258->349|1357->439|1396->440|1425->444|1442->453|1489->492|1527->493|1558->498|1753->666|1792->667|1833->680|1881->701|1893->704|1919->709|1959->732|1998->733|2039->746|2090->770|2102->773|2128->778|2176->795|2215->806|2374->938|2467->1009|2748->1263|2761->1267|2774->1271|2821->1280|2866->1297|2909->1313|2933->1316|2963->1319|2987->1322|3043->1347|3086->1362|3283->1532|3301->1541|3906->2125|3945->2136|4028->2192|4044->2199|4057->2203|4123->2231|4166->2247|4181->2253|4194->2257|4243->2268|4288->2285|4348->2318|4364->2325|4393->2333|4422->2335|4441->2345|4468->2351|4497->2353|4516->2363|4542->2368|4580->2379|4596->2386|4638->2406|4668->2408|4683->2413|4714->2422|4781->2461|4796->2466|4824->2472|5002->2623|5016->2628|5046->2637|5083->2647|5097->2652|5124->2658|5196->2699|5241->2713|5280->2724|5643->3060|5682->3061|5725->3076|5838->3161|5855->3168|5893->3184|5932->3195|5949->3202|5991->3222|6038->3252|6077->3253|6120->3268|6228->3349|6245->3356|6283->3372|6322->3383|6339->3390|6381->3410|6434->3432|6473->3443|6553->3493|6585->3495|6613->3496|6662->3517|6691->3518|6721->3521|6794->3566|6823->3567|6855->3572|6911->3601|6939->3602|6993->3628|7022->3629|7054->3634|7088->3641|7104->3648|7130->3653|7174->3670|7193->3680|7220->3686|7249->3688|7268->3698|7294->3703|7323->3705|7339->3712|7385->3736|7433->3757|7510->3813|7553->3829|7612->3867|7925->4152|7954->4153|7988->4160|8051->4196|8067->4203|8096->4211|8125->4213|8144->4223|8171->4229|8200->4231|8219->4241|8245->4246|8283->4257|8299->4264|8345->4288|8790->4706|8818->4707|8848->4710|8876->4711|8956->4763|8985->4764|9017->4769|9124->4849|9140->4856|9166->4861|9195->4863|9214->4873|9241->4879|9270->4881|9289->4891|9315->4896|9397->4950|9414->4957|9456->4977|9502->4994|9532->4995|9566->5002|9691->5099|9720->5100|9756->5109|9805->5131|9833->5132|9861->5133|9894->5138|9923->5139|9960->5148|10041->5201|10070->5202|10105->5209|10179->5255|10208->5256|10241->5261|10270->5262|10301->5265|10330->5266
                  LINES: 14->1|21->6|24->7|24->7|24->7|24->7|25->8|25->8|25->8|25->8|26->9|29->12|29->12|30->13|30->13|30->13|30->13|31->14|31->14|32->15|32->15|32->15|32->15|33->16|34->17|35->18|35->18|39->22|39->22|39->22|39->22|40->23|40->23|40->23|40->23|40->23|41->24|42->25|46->29|46->29|59->42|60->43|61->44|61->44|61->44|61->44|62->45|62->45|62->45|62->45|63->46|64->47|64->47|64->47|64->47|64->47|64->47|64->47|64->47|64->47|64->47|64->47|64->47|64->47|64->47|64->47|64->47|64->47|64->47|66->49|66->49|66->49|66->49|66->49|66->49|68->51|69->52|70->53|75->58|75->58|76->59|76->59|76->59|76->59|76->59|76->59|76->59|77->60|77->60|78->61|78->61|78->61|78->61|78->61|78->61|78->61|79->62|80->63|84->67|85->68|86->69|87->70|87->70|88->71|88->71|88->71|89->72|90->73|90->73|92->75|92->75|93->76|93->76|93->76|93->76|93->76|93->76|93->76|93->76|93->76|93->76|93->76|93->76|93->76|94->77|94->77|95->78|95->78|97->80|97->80|98->81|99->82|99->82|99->82|99->82|99->82|99->82|99->82|99->82|99->82|99->82|99->82|99->82|106->89|106->89|107->90|107->90|109->92|109->92|110->93|111->94|111->94|111->94|111->94|111->94|111->94|111->94|111->94|111->94|111->94|111->94|111->94|111->94|111->94|112->95|114->97|114->97|115->98|116->99|116->99|116->99|116->99|116->99|117->100|118->101|118->101|119->102|120->103|120->103|121->104|121->104|122->105|122->105
                  -- GENERATED --
              */
          