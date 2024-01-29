
package gitbucket.core.repo.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object editor extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template11[String,gitbucket.core.service.RepositoryService.RepositoryInfo,List[String],Option[String],gitbucket.core.util.JGitUtil.ContentInfo,Boolean,String,String,Boolean,Int,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(branch: String,
  repository: gitbucket.core.service.RepositoryService.RepositoryInfo,
  pathList: List[String],
  fileName: Option[String],
  content: gitbucket.core.util.JGitUtil.ContentInfo,
  protectedBranch: Boolean,
  commit: String,
  newLineMode: String = "auto",
  useSoftTabs: Boolean = false,
  tabSize: Int = 8
)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*12.2*/import gitbucket.core.view.helpers


Seq[Any](_display_(/*13.2*/gitbucket/*13.11*/.core.html.main(if(fileName.isEmpty) "New File" else s"Editing ${fileName.get} at ${branch} - ${repository.owner}/${repository.name}", Some(repository))/*13.163*/ {_display_(Seq[Any](format.raw/*13.165*/("""
  """),_display_(/*14.4*/gitbucket/*14.13*/.core.html.menu("files", repository)/*14.49*/{_display_(Seq[Any](format.raw/*14.50*/("""
    """),_display_(if(protectedBranch)/*15.25*/{_display_(Seq[Any](format.raw/*15.26*/("""
      """),format.raw/*16.7*/("""<div class="alert alert-danger">branch """),_display_(/*16.47*/branch),format.raw/*16.53*/(""" """),format.raw/*16.54*/("""is protected.</div>
    """)))} else {null} ),format.raw/*17.6*/("""
    """),format.raw/*18.5*/("""<form method="POST" action=""""),_display_(/*18.34*/helpers/*18.41*/.url(repository)),format.raw/*18.57*/("""/"""),_display_(if(fileName.isEmpty)/*18.79*/{_display_(Seq[Any](format.raw/*18.80*/("""create""")))}else/*18.91*/{_display_(Seq[Any](format.raw/*18.92*/("""update""")))}),format.raw/*18.99*/("""" validate="true" autocomplete="off">
      <span class="error" id="error-newFileName"></span>
      <span class="error" id="error-commit"></span>
      <div class="head">
        <a href=""""),_display_(/*22.19*/helpers/*22.26*/.url(repository)),format.raw/*22.42*/("""/tree/"""),_display_(/*22.49*/helpers/*22.56*/.encodeRefName(branch)),format.raw/*22.78*/("""">"""),_display_(/*22.81*/repository/*22.91*/.name),format.raw/*22.96*/("""</a> /
        """),_display_(/*23.10*/pathList/*23.18*/.zipWithIndex.map/*23.35*/ { case (section, i) =>_display_(Seq[Any](format.raw/*23.58*/("""
          """),format.raw/*24.11*/("""<a href=""""),_display_(/*24.21*/helpers/*24.28*/.url(repository)),format.raw/*24.44*/("""/tree/"""),_display_(/*24.51*/helpers/*24.58*/.encodeRefName((branch :: pathList.take(i + 1)).mkString("/"))),format.raw/*24.120*/("""">"""),_display_(/*24.123*/section),format.raw/*24.130*/("""</a> /
        """)))}),format.raw/*25.10*/("""
        """),format.raw/*26.9*/("""<input type="text" name="newFileName" id="newFileName" class="form-control" placeholder="Name your file..." value=""""),_display_(/*26.125*/fileName),format.raw/*26.133*/("""" style="display: inline; width: 300px;" aria-label="New file name"/>
        <input type="hidden" name="oldFileName" id="oldFileName" value=""""),_display_(/*27.74*/fileName),format.raw/*27.82*/(""""/>
        <input type="hidden" name="branch" id="branch" value=""""),_display_(/*28.64*/branch),format.raw/*28.70*/(""""/>
        <input type="hidden" name="path" id="path" value=""""),_display_(/*29.60*/pathList/*29.68*/.mkString("/")),format.raw/*29.82*/(""""/>
      </div>
      <table class="table table-bordered">
        <tr>
          <th>
            <div class="pull-right">
              <select id="wrap" class="form-control" style="margin-bottom: 0px; padding: 0px;" aria-label="Wrap">
                <optgroup label="Line Wrap Mode">
                  <option value="false">No wrap</option>
                  <option value="true">Soft wrap</option>
                </optgroup>
              </select>
            </div>
            <div class="pull-right">
              <select id="theme" class="form-control" style="margin-bottom: 0px; padding: 0px;" aria-label="Theme">
                <optgroup label="Editor Theme">
                  <option value="ambiance">Ambiance</option>
                  <option value="chaos">Chaos</option>
                  <option value="chrome">Chrome</option>
                  <option value="clouds">Clouds</option>
                  <option value="clouds_midnight">Clouds Midnight</option>
                  <option value="cobalt">Cobalt</option>
                  <option value="crimson_editor">Crimson</option>
                  <option value="dawn">Dawn</option>
                  <option value="dracula">Dracula</option>
                  <option value="dreamweaver">Dreamweaver</option>
                  <option value="eclipse">Eclipse</option>
                  <option value="github">GitHub</option>
                  <option value="gob">Gob</option>
                  <option value="gruvbox">Gruvbox</option>
                  <option value="idle_fingers">Idle Fingers</option>
                  <option value="iplastic">Iplastic</option>
                  <option value="katzenmilch">Katzenmilch</option>
                  <option value="kr_theme">Kr</option>
                  <option value="kuroir">Kuroir</option>
                  <option value="merbivore">Merbivore</option>
                  <option value="mono_industrial">Mono Industrial</option>
                  <option selected value="monokai">Monokai</option>
                  <option value="nord_dark">Nord Dark</option>
                  <option value="pastel_on_dark">Pastel on Dark</option>
                  <option value="solarized_dark">Solarized Dark</option>
                  <option value="solarized_light">Solarized Light</option>
                  <option value="sqlserver">Sqlserver</option>
                  <option value="terminal">Terminal</option>
                  <option value="textmate">Textmate</option>
                  <option value="tomorrow">Tomorrow</option>
                  <option value="tomorrow_night">Tomorrow Night</option>
                  <option value="tomorrow_night_bright">Tomorrow Night Bright</option>
                  <option value="tomorrow_night_eighties">Tomorrow Night Eighties</option>
                  <option value="twilight">Twilight</option>
                  <option value="vibrant_ink">Vibrant Ink</option>
                  <option value="xcode">Xcode</option>
                </optgroup>
              </select>
            </div>
            <div class="btn-group" data-toggle="buttons-radio">
              <input type="button" id="btn-code" class="btn btn-default btn-small active" value="Code">
              <input type="button" id="btn-preview" class="btn btn-default btn-small" value="Preview">
            </div>
          </th>
        </tr>
        <tr>
          <td>
            <div id="editor" style="width: 100%; height: 600px;"></div>
            <div id="preview" style="width: 100%; display: none;"></div>
          </td>
        </tr>
      </table>
      <div class="panel panel-default issue-comment-box">
        <div class="panel-body">
          <label for="message" class="strong">Commit changes</label>
          <div class="form-group">
            <input type="text" id="message" name="message" class="form-control"/>
          </div>
          <div class="form-group">
            <div class="col-md-12">
              <label class="radio">
                <input type="radio" id="newBranch" name="newBranch" value="false" checked>
                <i class='octicon octicon-git-commit'></i><span>Commit directly to the <strong style="background-color: lightblue; font-family: Consolas">"""),_display_(/*107.156*/branch),format.raw/*107.162*/("""</strong> branch.</span>
              </label>
              <label class="radio">
                <input type="radio" id="newBranch"  name="newBranch" value="true">
                <i class='octicon octicon-git-pull-request'></i><span>Create a <strong>new branch</strong> for this commit and start a pull request.</span>
              </label>
            </div>
          </div>
          <div style="text-align: right;">
            """),_display_(if(fileName.isEmpty)/*116.34*/{_display_(Seq[Any](format.raw/*116.35*/("""
              """),format.raw/*117.15*/("""<a href=""""),_display_(/*117.25*/helpers/*117.32*/.url(repository)),format.raw/*117.48*/("""/tree/"""),_display_(/*117.55*/helpers/*117.62*/.encodeRefName((branch :: pathList).mkString("/"))),format.raw/*117.112*/("""" class="btn btn-default">Cancel</a>
            """)))}else/*118.20*/{_display_(Seq[Any](format.raw/*118.21*/("""
              """),format.raw/*119.15*/("""<a href=""""),_display_(/*119.25*/helpers/*119.32*/.url(repository)),format.raw/*119.48*/("""/blob/"""),_display_(/*119.55*/helpers/*119.62*/.encodeRefName((branch :: pathList ++ Seq(fileName.get)).mkString("/"))),format.raw/*119.133*/("""" class="btn btn-default">Cancel</a>
            """)))}),format.raw/*120.14*/("""
            """),format.raw/*121.13*/("""<input type="submit" id="commitButton" class="btn btn-success" value="Commit changes" disabled="true"/>
            <input type="hidden" id="charset" name="charset" value=""""),_display_(/*122.70*/content/*122.77*/.charset),format.raw/*122.85*/(""""/>
            <input type="hidden" id="lineSeparator" name="lineSeparator" value=""""),_display_(/*123.82*/content/*123.89*/.lineSeparator),format.raw/*123.103*/(""""/>
            <input type="hidden" id="content" name="content" value=""/>
            <input type="hidden" id="initial" value=""""),_display_(/*125.55*/content/*125.62*/.content),format.raw/*125.70*/(""""/>
            <input type="hidden" id="commit" name="commit" value=""""),_display_(/*126.68*/commit),format.raw/*126.74*/(""""/>
          </div>
        </div>
      </div>
    </form>
  """)))}),format.raw/*131.4*/("""
""")))}),format.raw/*132.2*/("""
"""),format.raw/*133.1*/("""<script src=""""),_display_(/*133.15*/helpers/*133.22*/.assets("/vendors/ace/ace.js")),format.raw/*133.52*/("""" type="text/javascript" charset="utf-8"></script>
<script src=""""),_display_(/*134.15*/helpers/*134.22*/.assets("/vendors/ace/ext-modelist.js")),format.raw/*134.61*/("""" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src=""""),_display_(/*135.38*/helpers/*135.45*/.assets("/vendors/jsdifflib/difflib.js")),format.raw/*135.85*/(""""></script>
<link href=""""),_display_(/*136.14*/helpers/*136.21*/.assets("/vendors/jsdifflib/diffview.css")),format.raw/*136.63*/("""" type="text/css" rel="stylesheet" />
<script>
$(function()"""),format.raw/*138.13*/("""{"""),format.raw/*138.14*/("""
  """),format.raw/*139.3*/("""$('#editor').text($('#initial').val());
  var editor = ace.edit("editor");

  if(typeof localStorage.getItem('gitbucket:editor:theme') == "string")"""),format.raw/*142.72*/("""{"""),format.raw/*142.73*/("""
    """),format.raw/*143.5*/("""$('#theme').val(localStorage.getItem('gitbucket:editor:theme'));
  """),format.raw/*144.3*/("""}"""),format.raw/*144.4*/("""

  """),format.raw/*146.3*/("""editor.setTheme("ace/theme/" + $('#theme').val());

  $('#theme').change(function()"""),format.raw/*148.32*/("""{"""),format.raw/*148.33*/("""
    """),format.raw/*149.5*/("""editor.setTheme("ace/theme/" + $('#theme').val());
    localStorage.setItem('gitbucket:editor:theme', $('#theme').val());
  """),format.raw/*151.3*/("""}"""),format.raw/*151.4*/(""");

  if(localStorage.getItem('gitbucket:editor:wrap') == 'true')"""),format.raw/*153.62*/("""{"""),format.raw/*153.63*/("""
    """),format.raw/*154.5*/("""editor.getSession().setUseWrapMode(true);
    $('#wrap').val('true');
  """),format.raw/*156.3*/("""}"""),format.raw/*156.4*/("""

  """),_display_(if(fileName.isDefined)/*158.26*/{_display_(Seq[Any](format.raw/*158.27*/("""
    """),format.raw/*159.5*/("""var modelist = ace.require("ace/ext/modelist");
    var mode = modelist.getModeForPath(""""),_display_(/*160.42*/fileName/*160.50*/.get),format.raw/*160.54*/("""");
    editor.getSession().setMode(mode.mode);
  """)))} else {null} ),format.raw/*162.4*/("""
  """),_display_(if(protectedBranch)/*163.23*/{_display_(Seq[Any](format.raw/*163.24*/("""
    """),format.raw/*164.5*/("""editor.setReadOnly(true);
  """)))} else {null} ),format.raw/*165.4*/("""
  """),format.raw/*166.3*/("""editor.getSession().setOption("tabSize", """),_display_(/*166.45*/tabSize),format.raw/*166.52*/(""");
  editor.getSession().setOption("newLineMode", """"),_display_(/*167.50*/newLineMode),format.raw/*167.61*/("""");
  editor.getSession().setOption("useSoftTabs", """),_display_(/*168.49*/useSoftTabs),format.raw/*168.60*/(""");

  editor.on('change', function()"""),format.raw/*170.33*/("""{"""),format.raw/*170.34*/("""
    """),format.raw/*171.5*/("""updateCommitButtonStatus();
  """),format.raw/*172.3*/("""}"""),format.raw/*172.4*/(""");

  function updateCommitButtonStatus()"""),format.raw/*174.38*/("""{"""),format.raw/*174.39*/("""
    """),format.raw/*175.5*/("""if(editor.getValue() == $('#initial').val() && $('#newFileName').val() == $('#oldFileName').val())"""),format.raw/*175.103*/("""{"""),format.raw/*175.104*/("""
      """),format.raw/*176.7*/("""$('#commitButton').attr('disabled', true);
    """),format.raw/*177.5*/("""}"""),format.raw/*177.6*/(""" """),format.raw/*177.7*/("""else """),format.raw/*177.12*/("""{"""),format.raw/*177.13*/("""
      """),format.raw/*178.7*/("""$('#commitButton').attr('disabled', false);
    """),format.raw/*179.5*/("""}"""),format.raw/*179.6*/("""
  """),format.raw/*180.3*/("""}"""),format.raw/*180.4*/("""

  """),format.raw/*182.3*/("""$('#wrap').change(function()"""),format.raw/*182.31*/("""{"""),format.raw/*182.32*/("""
    """),format.raw/*183.5*/("""if($('#wrap option:selected').val() == 'true')"""),format.raw/*183.51*/("""{"""),format.raw/*183.52*/("""
      """),format.raw/*184.7*/("""editor.getSession().setUseWrapMode(true);
      localStorage.setItem('gitbucket:editor:wrap', 'true');
    """),format.raw/*186.5*/("""}"""),format.raw/*186.6*/(""" """),format.raw/*186.7*/("""else """),format.raw/*186.12*/("""{"""),format.raw/*186.13*/("""
      """),format.raw/*187.7*/("""editor.getSession().setUseWrapMode(false);
      localStorage.setItem('gitbucket:editor:wrap', 'false');
    """),format.raw/*189.5*/("""}"""),format.raw/*189.6*/("""
  """),format.raw/*190.3*/("""}"""),format.raw/*190.4*/(""");

  $('#newFileName').watch(function()"""),format.raw/*192.37*/("""{"""),format.raw/*192.38*/("""
    """),format.raw/*193.5*/("""updateCommitButtonStatus();
  """),format.raw/*194.3*/("""}"""),format.raw/*194.4*/(""");

  $('#commitButton').click(function()"""),format.raw/*196.38*/("""{"""),format.raw/*196.39*/("""
    """),format.raw/*197.5*/("""$('#content').val(editor.getValue());
  """),format.raw/*198.3*/("""}"""),format.raw/*198.4*/(""");

  $('#btn-code').click(function()"""),format.raw/*200.34*/("""{"""),format.raw/*200.35*/("""
    """),format.raw/*201.5*/("""$('#editor').show();
    $('#preview').hide();
    $('#btn-preview').removeClass('active');
  """),format.raw/*204.3*/("""}"""),format.raw/*204.4*/(""");

  $('#btn-preview').click(function()"""),format.raw/*206.37*/("""{"""),format.raw/*206.38*/("""
    """),format.raw/*207.5*/("""$('#editor').hide();
    $('#preview').show();
    $('#btn-code').removeClass('active');

    """),_display_(if(fileName.map(helpers.isRenderable _).getOrElse(false))/*211.63*/ {_display_(Seq[Any](format.raw/*211.65*/("""
      """),format.raw/*212.7*/("""// update preview
      $('#preview').html('<img src=""""),_display_(/*213.38*/helpers/*213.45*/.assets("/common/images/indicator.gif")),format.raw/*213.84*/(""""> Previewing...');
      $.post('"""),_display_(/*214.16*/helpers/*214.23*/.url(repository)),format.raw/*214.39*/("""/_preview', """),format.raw/*214.51*/("""{"""),format.raw/*214.52*/("""
        """),format.raw/*215.9*/("""content          : editor.getValue(),
        enableWikiLink   : false,
        filename         : $('#newFileName').val(),
        enableRefsLink   : false,
        enableLineBreaks : false,
        enableTaskList   : false
      """),format.raw/*221.7*/("""}"""),format.raw/*221.8*/(""", function(data)"""),format.raw/*221.24*/("""{"""),format.raw/*221.25*/("""
        """),format.raw/*222.9*/("""$('#preview').empty().append(
          $('<div class="markdown-body" style="padding-left: 20px; padding-right: 20px;">').html(data));
        prettyPrint();
      """),format.raw/*225.7*/("""}"""),format.raw/*225.8*/(""");
    """)))}else/*226.12*/{_display_(Seq[Any](format.raw/*226.13*/("""
      """),format.raw/*227.7*/("""// Show diff
      $('#preview').empty()
        .append($('<div id="diffText">'))
        .append($('<textarea id="newText" style="display: none;">').data('file-name',$("#newFileName").val()).data('val', editor.getValue()))
        .append($('<textarea id="oldText" style="display: none;">').data('file-name',$("#oldFileName").val()).data('val', $('#initial').val()));
      diffUsingJS('oldText', 'newText', 'diffText', 1);
    """)))}),format.raw/*233.6*/("""
  """),format.raw/*234.3*/("""}"""),format.raw/*234.4*/(""");
"""),format.raw/*235.1*/("""}"""),format.raw/*235.2*/(""");
</script>
"""))
      }
    }
  }

  def render(branch:String,repository:gitbucket.core.service.RepositoryService.RepositoryInfo,pathList:List[String],fileName:Option[String],content:gitbucket.core.util.JGitUtil.ContentInfo,protectedBranch:Boolean,commit:String,newLineMode:String,useSoftTabs:Boolean,tabSize:Int,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(branch,repository,pathList,fileName,content,protectedBranch,commit,newLineMode,useSoftTabs,tabSize)(context)

  def f:((String,gitbucket.core.service.RepositoryService.RepositoryInfo,List[String],Option[String],gitbucket.core.util.JGitUtil.ContentInfo,Boolean,String,String,Boolean,Int) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (branch,repository,pathList,fileName,content,protectedBranch,commit,newLineMode,useSoftTabs,tabSize) => (context) => apply(branch,repository,pathList,fileName,content,protectedBranch,commit,newLineMode,useSoftTabs,tabSize)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/repo/editor.scala.html
                  HASH: 25304fa690973ba5866c3bef07ddb330e3ec4914
                  MATRIX: 775->1|1227->381|1291->417|1309->426|1471->578|1512->580|1542->584|1560->593|1605->629|1644->630|1696->655|1735->656|1769->663|1836->703|1863->709|1892->710|1960->735|1992->740|2048->769|2064->776|2101->792|2150->814|2189->815|2219->826|2258->827|2296->834|2513->1024|2529->1031|2566->1047|2600->1054|2616->1061|2659->1083|2689->1086|2708->1096|2734->1101|2777->1117|2794->1125|2820->1142|2881->1165|2920->1176|2957->1186|2973->1193|3010->1209|3044->1216|3060->1223|3144->1285|3175->1288|3204->1295|3251->1311|3287->1320|3431->1436|3461->1444|3631->1587|3660->1595|3754->1662|3781->1668|3871->1731|3888->1739|3923->1753|8196->5997|8225->6003|8711->6461|8751->6462|8795->6477|8833->6487|8850->6494|8888->6510|8923->6517|8940->6524|9013->6574|9087->6630|9127->6631|9171->6646|9209->6656|9226->6663|9264->6679|9299->6686|9316->6693|9410->6764|9492->6814|9534->6827|9735->7000|9752->7007|9782->7015|9895->7100|9912->7107|9949->7121|10107->7251|10124->7258|10154->7266|10253->7337|10281->7343|10376->7407|10409->7409|10438->7410|10480->7424|10497->7431|10549->7461|10642->7526|10659->7533|10720->7572|10836->7660|10853->7667|10915->7707|10968->7732|10985->7739|11049->7781|11137->7840|11167->7841|11198->7844|11374->7991|11404->7992|11437->7997|11532->8064|11561->8065|11593->8069|11705->8152|11735->8153|11768->8158|11920->8282|11949->8283|12043->8348|12073->8349|12106->8354|12206->8426|12235->8427|12290->8454|12330->8455|12363->8460|12480->8549|12498->8557|12524->8561|12619->8612|12670->8635|12710->8636|12743->8641|12816->8670|12847->8673|12917->8715|12946->8722|13026->8774|13059->8785|13139->8837|13172->8848|13237->8884|13267->8885|13300->8890|13358->8920|13387->8921|13457->8962|13487->8963|13520->8968|13648->9066|13679->9067|13714->9074|13789->9121|13818->9122|13847->9123|13881->9128|13911->9129|13946->9136|14022->9184|14051->9185|14082->9188|14111->9189|14143->9193|14200->9221|14230->9222|14263->9227|14338->9273|14368->9274|14403->9281|14538->9388|14567->9389|14596->9390|14630->9395|14660->9396|14695->9403|14832->9512|14861->9513|14892->9516|14921->9517|14990->9557|15020->9558|15053->9563|15111->9593|15140->9594|15210->9635|15240->9636|15273->9641|15341->9681|15370->9682|15436->9719|15466->9720|15499->9725|15621->9819|15650->9820|15719->9860|15749->9861|15782->9866|15962->10018|16003->10020|16038->10027|16121->10082|16138->10089|16199->10128|16262->10163|16279->10170|16317->10186|16358->10198|16388->10199|16425->10208|16684->10439|16713->10440|16758->10456|16788->10457|16825->10466|17017->10630|17046->10631|17078->10645|17118->10646|17153->10653|17615->11084|17646->11087|17675->11088|17706->11091|17735->11092
                  LINES: 14->1|27->12|30->13|30->13|30->13|30->13|31->14|31->14|31->14|31->14|32->15|32->15|33->16|33->16|33->16|33->16|34->17|35->18|35->18|35->18|35->18|35->18|35->18|35->18|35->18|35->18|39->22|39->22|39->22|39->22|39->22|39->22|39->22|39->22|39->22|40->23|40->23|40->23|40->23|41->24|41->24|41->24|41->24|41->24|41->24|41->24|41->24|41->24|42->25|43->26|43->26|43->26|44->27|44->27|45->28|45->28|46->29|46->29|46->29|124->107|124->107|133->116|133->116|134->117|134->117|134->117|134->117|134->117|134->117|134->117|135->118|135->118|136->119|136->119|136->119|136->119|136->119|136->119|136->119|137->120|138->121|139->122|139->122|139->122|140->123|140->123|140->123|142->125|142->125|142->125|143->126|143->126|148->131|149->132|150->133|150->133|150->133|150->133|151->134|151->134|151->134|152->135|152->135|152->135|153->136|153->136|153->136|155->138|155->138|156->139|159->142|159->142|160->143|161->144|161->144|163->146|165->148|165->148|166->149|168->151|168->151|170->153|170->153|171->154|173->156|173->156|175->158|175->158|176->159|177->160|177->160|177->160|179->162|180->163|180->163|181->164|182->165|183->166|183->166|183->166|184->167|184->167|185->168|185->168|187->170|187->170|188->171|189->172|189->172|191->174|191->174|192->175|192->175|192->175|193->176|194->177|194->177|194->177|194->177|194->177|195->178|196->179|196->179|197->180|197->180|199->182|199->182|199->182|200->183|200->183|200->183|201->184|203->186|203->186|203->186|203->186|203->186|204->187|206->189|206->189|207->190|207->190|209->192|209->192|210->193|211->194|211->194|213->196|213->196|214->197|215->198|215->198|217->200|217->200|218->201|221->204|221->204|223->206|223->206|224->207|228->211|228->211|229->212|230->213|230->213|230->213|231->214|231->214|231->214|231->214|231->214|232->215|238->221|238->221|238->221|238->221|239->222|242->225|242->225|243->226|243->226|244->227|250->233|251->234|251->234|252->235|252->235
                  -- GENERATED --
              */
          