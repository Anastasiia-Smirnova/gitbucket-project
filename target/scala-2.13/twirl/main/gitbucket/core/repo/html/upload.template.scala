
package gitbucket.core.repo.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object upload extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template6[String,gitbucket.core.service.RepositoryService.RepositoryInfo,List[String],Boolean,String,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(branch: String,
  repository: gitbucket.core.service.RepositoryService.RepositoryInfo,
  pathList: List[String],
  protectedBranch: Boolean,
  commit: String)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*6.2*/import gitbucket.core.view.helpers
/*7.2*/import gitbucket.core.util.FileUtil


Seq[Any](_display_(/*8.2*/gitbucket/*8.11*/.core.html.main(s"Upload Files at ${branch} - ${repository.owner}/${repository.name}", Some(repository))/*8.115*/ {_display_(Seq[Any](format.raw/*8.117*/("""
  """),_display_(/*9.4*/gitbucket/*9.13*/.core.html.menu("files", repository)/*9.49*/{_display_(Seq[Any](format.raw/*9.50*/("""
    """),_display_(if(protectedBranch)/*10.25*/{_display_(Seq[Any](format.raw/*10.26*/("""
      """),format.raw/*11.7*/("""<div class="alert alert-danger">branch """),_display_(/*11.47*/branch),format.raw/*11.53*/(""" """),format.raw/*11.54*/("""is protected.</div>
    """)))} else {null} ),format.raw/*12.6*/("""
    """),format.raw/*13.5*/("""<form method="POST" action=""""),_display_(/*13.34*/helpers/*13.41*/.url(repository)),format.raw/*13.57*/("""/upload" id="upload-form" autocomplete="off">
      <div class="head">
        <a href=""""),_display_(/*15.19*/helpers/*15.26*/.url(repository)),format.raw/*15.42*/("""/tree/"""),_display_(/*15.49*/helpers/*15.56*/.encodeRefName(branch)),format.raw/*15.78*/("""">"""),_display_(/*15.81*/repository/*15.91*/.name),format.raw/*15.96*/("""</a> /
        """),_display_(/*16.10*/pathList/*16.18*/.zipWithIndex.map/*16.35*/ { case (section, i) =>_display_(Seq[Any](format.raw/*16.58*/("""
          """),format.raw/*17.11*/("""<a href=""""),_display_(/*17.21*/helpers/*17.28*/.url(repository)),format.raw/*17.44*/("""/tree/"""),_display_(/*17.51*/helpers/*17.58*/.encodeRefName(branch + "/" + pathList.take(i + 1).mkString("/"))),format.raw/*17.123*/("""">"""),_display_(/*17.126*/section),format.raw/*17.133*/("""</a> /
        """)))}),format.raw/*18.10*/("""
        """),format.raw/*19.9*/("""<input type="hidden" name="branch" id="branch" value=""""),_display_(/*19.64*/branch),format.raw/*19.70*/(""""/>
        <input type="hidden" name="path" id="path" value=""""),_display_(/*20.60*/pathList/*20.68*/.mkString("/")),format.raw/*20.82*/(""""/>
      </div>
      <table class="table table-bordered">
        <tr>
          <td id="upload-td">
            <div id="upload-area">
              Drag files here to add them to your repository
            </div>
            <ul id="upload-files">
            </ul>
          </td>
        </tr>
      </table>
      <div class="panel panel-default issue-comment-box">
        <div class="panel-body">
          <div>
            <strong>Commit changes</strong>
          </div>
          <div class="form-group">
            <input type="text" name="message" class="form-control"/>
          </div>
          <div class="form-group">
            <div class="col-md-12">
              <label class="radio">
                <input type="radio" id="newBranch" name="newBranch" value="false" checked>
                <i class='octicon octicon-git-commit'></i><span>Commit directly to the <strong style="background-color: lightblue; font-family: Consolas">"""),_display_(/*45.156*/branch),format.raw/*45.162*/("""</strong> branch.</span>
              </label>
              <label class="radio">
                <input type="radio" id="newBranch"  name="newBranch" value="true">
                <i class='octicon octicon-git-pull-request'></i><span>Create a <strong>new branch</strong> for this commit and start a pull request.</span>
              </label>
            </div>
          </div>
          <div style="text-align: right;">
            <a href=""""),_display_(/*54.23*/helpers/*54.30*/.url(repository)),format.raw/*54.46*/("""/tree/"""),_display_(/*54.53*/helpers/*54.60*/.encodeRefName(branch + "/" + pathList.mkString("/"))),format.raw/*54.113*/("""" class="btn btn-default">Cancel</a>
            <input type="submit" id="commit" class="btn btn-success" value="Commit changes" disabled="true"/>
            <input type="hidden" id="upload-files-data" name="uploadFiles" value=""/>
            <input type="hidden" id="commit" name="commit" value=""""),_display_(/*57.68*/commit),format.raw/*57.74*/(""""/>
          </div>
        </div>
      </div>
    </form>
  """)))}),format.raw/*62.4*/("""
""")))}),format.raw/*63.2*/("""
"""),format.raw/*64.1*/("""<script>
$(function()"""),format.raw/*65.13*/("""{"""),format.raw/*65.14*/("""
  """),format.raw/*66.3*/("""$('#upload-area').dropzone("""),format.raw/*66.30*/("""{"""),format.raw/*66.31*/("""
    """),format.raw/*67.5*/("""url: '"""),_display_(/*67.12*/context/*67.19*/.path),format.raw/*67.24*/("""/upload/tmp',
    maxFilesize: """),_display_(/*68.19*/{context.settings.upload.maxFileSize / 1024 / 1024}),format.raw/*68.70*/(""",
    timeout: """),_display_(/*69.15*/{context.settings.upload.timeout}),format.raw/*69.48*/(""",
    clickable: true,
    previewTemplate: "<div class=\"dz-preview\">\n  <div class=\"dz-progress\"><span class=\"dz-upload\" data-dz-uploadprogress>Uploading your files...</span></div>\n  <div class=\"dz-error-message\"><span data-dz-errormessage></span></div>\n</div>",
    success: function(file, id) """),format.raw/*72.33*/("""{"""),format.raw/*72.34*/("""
      """),format.raw/*73.7*/("""$(file.previewElement).remove();
      $('#upload-files').append($('<li class="upload-file">')
        .append($('<span>').data('id', id).text(file.name))
        .append($('<a class="delete" href="javascript:void(0);" style="margin-left: 4px;">(delete)</a>')));
      updateCommitButtonStatus();
    """),format.raw/*78.5*/("""}"""),format.raw/*78.6*/("""
  """),format.raw/*79.3*/("""}"""),format.raw/*79.4*/(""");

  $('#upload-form').submit(function()"""),format.raw/*81.38*/("""{"""),format.raw/*81.39*/("""
    """),format.raw/*82.5*/("""try """),format.raw/*82.9*/("""{"""),format.raw/*82.10*/("""
      """),format.raw/*83.7*/("""var data = '';
      $.each($('li.upload-file span'), function(i, e)"""),format.raw/*84.54*/("""{"""),format.raw/*84.55*/("""
        """),format.raw/*85.9*/("""data = data + $(e).data('id') + ':' + $(e).text() + '\n';
      """),format.raw/*86.7*/("""}"""),format.raw/*86.8*/(""");
      $('#upload-files-data').val(data);
    """),format.raw/*88.5*/("""}"""),format.raw/*88.6*/(""" """),format.raw/*88.7*/("""catch(e)"""),format.raw/*88.15*/("""{"""),format.raw/*88.16*/("""
      """),format.raw/*89.7*/("""console.log(e);
    """),format.raw/*90.5*/("""}"""),format.raw/*90.6*/("""
  """),format.raw/*91.3*/("""}"""),format.raw/*91.4*/(""");

  $(document).on('click', 'a.delete', function(e)"""),format.raw/*93.50*/("""{"""),format.raw/*93.51*/("""
     """),format.raw/*94.6*/("""$(e.target).parent().remove();
    updateCommitButtonStatus();
  """),format.raw/*96.3*/("""}"""),format.raw/*96.4*/(""");

  function updateCommitButtonStatus()"""),format.raw/*98.38*/("""{"""),format.raw/*98.39*/("""
    """),format.raw/*99.5*/("""$('#commit').attr('disabled', $('.upload-file').length == 0);
  """),format.raw/*100.3*/("""}"""),format.raw/*100.4*/("""
"""),format.raw/*101.1*/("""}"""),format.raw/*101.2*/(""");
</script>
"""))
      }
    }
  }

  def render(branch:String,repository:gitbucket.core.service.RepositoryService.RepositoryInfo,pathList:List[String],protectedBranch:Boolean,commit:String,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(branch,repository,pathList,protectedBranch,commit)(context)

  def f:((String,gitbucket.core.service.RepositoryService.RepositoryInfo,List[String],Boolean,String) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (branch,repository,pathList,protectedBranch,commit) => (context) => apply(branch,repository,pathList,protectedBranch,commit)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/repo/upload.scala.html
                  HASH: f43bf13d6950183688aa5ed49c65b6678d458737
                  MATRIX: 699->1|984->215|1026->251|1090->288|1107->297|1220->401|1260->403|1289->407|1306->416|1350->452|1388->453|1440->478|1479->479|1513->486|1580->526|1607->532|1636->533|1704->558|1736->563|1792->592|1808->599|1845->615|1961->704|1977->711|2014->727|2048->734|2064->741|2107->763|2137->766|2156->776|2182->781|2225->797|2242->805|2268->822|2329->845|2368->856|2405->866|2421->873|2458->889|2492->896|2508->903|2595->968|2626->971|2655->978|2702->994|2738->1003|2820->1058|2847->1064|2937->1127|2954->1135|2989->1149|3975->2107|4003->2113|4477->2560|4493->2567|4530->2583|4564->2590|4580->2597|4655->2650|4982->2950|5009->2956|5103->3020|5135->3022|5163->3023|5212->3044|5241->3045|5271->3048|5326->3075|5355->3076|5387->3081|5421->3088|5437->3095|5463->3100|5522->3132|5594->3183|5637->3199|5691->3232|6025->3538|6054->3539|6088->3546|6416->3847|6444->3848|6474->3851|6502->3852|6571->3893|6600->3894|6632->3899|6663->3903|6692->3904|6726->3911|6822->3979|6851->3980|6887->3989|6978->4053|7006->4054|7081->4102|7109->4103|7137->4104|7173->4112|7202->4113|7236->4120|7283->4140|7311->4141|7341->4144|7369->4145|7450->4198|7479->4199|7512->4205|7604->4270|7632->4271|7701->4312|7730->4313|7762->4318|7854->4382|7883->4383|7912->4384|7941->4385
                  LINES: 14->1|21->6|22->7|25->8|25->8|25->8|25->8|26->9|26->9|26->9|26->9|27->10|27->10|28->11|28->11|28->11|28->11|29->12|30->13|30->13|30->13|30->13|32->15|32->15|32->15|32->15|32->15|32->15|32->15|32->15|32->15|33->16|33->16|33->16|33->16|34->17|34->17|34->17|34->17|34->17|34->17|34->17|34->17|34->17|35->18|36->19|36->19|36->19|37->20|37->20|37->20|62->45|62->45|71->54|71->54|71->54|71->54|71->54|71->54|74->57|74->57|79->62|80->63|81->64|82->65|82->65|83->66|83->66|83->66|84->67|84->67|84->67|84->67|85->68|85->68|86->69|86->69|89->72|89->72|90->73|95->78|95->78|96->79|96->79|98->81|98->81|99->82|99->82|99->82|100->83|101->84|101->84|102->85|103->86|103->86|105->88|105->88|105->88|105->88|105->88|106->89|107->90|107->90|108->91|108->91|110->93|110->93|111->94|113->96|113->96|115->98|115->98|116->99|117->100|117->100|118->101|118->101
                  -- GENERATED --
              */
          