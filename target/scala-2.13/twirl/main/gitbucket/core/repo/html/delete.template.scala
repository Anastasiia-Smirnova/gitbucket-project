
package gitbucket.core.repo.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object delete extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template7[String,gitbucket.core.service.RepositoryService.RepositoryInfo,List[String],String,gitbucket.core.util.JGitUtil.ContentInfo,String,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(branch: String,
  repository: gitbucket.core.service.RepositoryService.RepositoryInfo,
  pathList: List[String],
  fileName: String,
  content: gitbucket.core.util.JGitUtil.ContentInfo,
  commit: String)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*7.2*/import gitbucket.core.view.helpers


Seq[Any](_display_(/*8.2*/gitbucket/*8.11*/.core.html.main(s"Deleting ${context.path} at ${fileName} - ${repository.owner}/${repository.name}", Some(repository))/*8.129*/ {_display_(Seq[Any](format.raw/*8.131*/("""
  """),_display_(/*9.4*/gitbucket/*9.13*/.core.html.menu("files", repository)/*9.49*/{_display_(Seq[Any](format.raw/*9.50*/("""
    """),format.raw/*10.5*/("""<form method="POST" action=""""),_display_(/*10.34*/helpers/*10.41*/.url(repository)),format.raw/*10.57*/("""/remove" validate="true">
      <span class="error" id="error-commit"></span>
      <div class="head">
        <a href=""""),_display_(/*13.19*/helpers/*13.26*/.url(repository)),format.raw/*13.42*/("""/tree/"""),_display_(/*13.49*/helpers/*13.56*/.encodeRefName(branch)),format.raw/*13.78*/("""">"""),_display_(/*13.81*/repository/*13.91*/.name),format.raw/*13.96*/("""</a> /
        """),_display_(/*14.10*/pathList/*14.18*/.zipWithIndex.map/*14.35*/ { case (section, i) =>_display_(Seq[Any](format.raw/*14.58*/("""
          """),format.raw/*15.11*/("""<a href=""""),_display_(/*15.21*/helpers/*15.28*/.url(repository)),format.raw/*15.44*/("""/tree/"""),_display_(/*15.51*/helpers/*15.58*/.encodeRefName((branch :: pathList.take(i + 1)).mkString("/"))),format.raw/*15.120*/("""">"""),_display_(/*15.123*/section),format.raw/*15.130*/("""</a> /
        """)))}),format.raw/*16.10*/("""
        """),_display_(/*17.10*/fileName),format.raw/*17.18*/("""
        """),format.raw/*18.9*/("""<input type="hidden" name="fileName" id="fileName" value=""""),_display_(/*18.68*/fileName),format.raw/*18.76*/(""""/>
        <input type="hidden" name="branch" id="branch" value=""""),_display_(/*19.64*/branch),format.raw/*19.70*/(""""/>
        <input type="hidden" name="path" id="path" value=""""),_display_(/*20.60*/pathList/*20.68*/.mkString("/")),format.raw/*20.82*/(""""/>
        <input type="hidden" name="commit" id="commit" value=""""),_display_(/*21.64*/commit),format.raw/*21.70*/(""""/>
      </div>
      <table class="table table-bordered diff-outside">
        <tr>
          <th style="font-weight: normal;" class="box-header">
            <span class="monospace">"""),_display_(/*26.38*/fileName),format.raw/*26.46*/("""</span>
            <div class="pull-right align-right">
              <a href=""""),_display_(/*28.25*/helpers/*28.32*/.url(repository)),format.raw/*28.48*/("""/blob/"""),_display_(/*28.55*/helpers/*28.62*/.encodeRefName((branch :: pathList ::: List(fileName)).mkString("/"))),format.raw/*28.131*/("""" class="btn btn-default btn-sm">View</a>
            </div>
          </th>
        </tr>
        <tr>
          <td>
            <div id="diffText"></div>
            <input type="hidden" id="newText" data-file-name=""""),_display_(/*35.64*/fileName),format.raw/*35.72*/("""" value="">
            <input type="hidden" id="oldText" data-file-name=""""),_display_(/*36.64*/fileName),format.raw/*36.72*/("""" value=""""),_display_(/*36.82*/content/*36.89*/.content),format.raw/*36.97*/("""">
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
                <i class='octicon octicon-git-commit'></i><span>Commit directly to the <strong style="background-color: lightblue; font-family: Consolas">"""),_display_(/*52.156*/branch),format.raw/*52.162*/("""</strong> branch.</span>
              </label>
              <label class="radio">
                <input type="radio" id="newBranch"  name="newBranch" value="true">
                <i class='octicon octicon-git-pull-request'></i><span>Create a <strong>new branch</strong> for this commit and start a pull request.</span>
              </label>
            </div>
          </div>
          <div style="text-align: right;">
            <a href=""""),_display_(/*61.23*/helpers/*61.30*/.url(repository)),format.raw/*61.46*/("""/blob/"""),_display_(/*61.53*/helpers/*61.60*/.encodeRefName((branch :: pathList ::: List(fileName)).mkString("/"))),format.raw/*61.129*/("""" class="btn btn-default">Cancel</a>
            <input type="submit" id="commitButton" class="btn btn-success" value="Commit changes"/>
          </div>
        </div>
      </div>
    </form>
  """)))}),format.raw/*67.4*/("""
""")))}),format.raw/*68.2*/("""
"""),format.raw/*69.1*/("""<script type="text/javascript" src=""""),_display_(/*69.38*/helpers/*69.45*/.assets("/vendors/jsdifflib/difflib.js")),format.raw/*69.85*/(""""></script>
<link href=""""),_display_(/*70.14*/helpers/*70.21*/.assets("/vendors/jsdifflib/diffview.css")),format.raw/*70.63*/("""" type="text/css" rel="stylesheet" />
<script>
$(function()"""),format.raw/*72.13*/("""{"""),format.raw/*72.14*/("""
  """),format.raw/*73.3*/("""diffUsingJS('oldText', 'newText', 'diffText', 1);
"""),format.raw/*74.1*/("""}"""),format.raw/*74.2*/(""");
</script>
"""))
      }
    }
  }

  def render(branch:String,repository:gitbucket.core.service.RepositoryService.RepositoryInfo,pathList:List[String],fileName:String,content:gitbucket.core.util.JGitUtil.ContentInfo,commit:String,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(branch,repository,pathList,fileName,content,commit)(context)

  def f:((String,gitbucket.core.service.RepositoryService.RepositoryInfo,List[String],String,gitbucket.core.util.JGitUtil.ContentInfo,String) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (branch,repository,pathList,fileName,content,commit) => (context) => apply(branch,repository,pathList,fileName,content,commit)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/repo/delete.scala.html
                  HASH: b1c95a52701a334fc97c89ffbf39045dfff4444c
                  MATRIX: 739->1|1069->260|1132->296|1149->305|1276->423|1316->425|1345->429|1362->438|1406->474|1444->475|1476->480|1532->509|1548->516|1585->532|1733->653|1749->660|1786->676|1820->683|1836->690|1879->712|1909->715|1928->725|1954->730|1997->746|2014->754|2040->771|2101->794|2140->805|2177->815|2193->822|2230->838|2264->845|2280->852|2364->914|2395->917|2424->924|2471->940|2508->950|2537->958|2573->967|2659->1026|2688->1034|2782->1101|2809->1107|2899->1170|2916->1178|2951->1192|3045->1259|3072->1265|3285->1451|3314->1459|3422->1540|3438->1547|3475->1563|3509->1570|3525->1577|3616->1646|3863->1866|3892->1874|3994->1949|4023->1957|4060->1967|4076->1974|4105->1982|4823->2672|4851->2678|5325->3125|5341->3132|5378->3148|5412->3155|5428->3162|5519->3231|5746->3428|5778->3430|5806->3431|5870->3468|5886->3475|5947->3515|5999->3540|6015->3547|6078->3589|6165->3648|6194->3649|6224->3652|6301->3702|6329->3703
                  LINES: 14->1|22->7|25->8|25->8|25->8|25->8|26->9|26->9|26->9|26->9|27->10|27->10|27->10|27->10|30->13|30->13|30->13|30->13|30->13|30->13|30->13|30->13|30->13|31->14|31->14|31->14|31->14|32->15|32->15|32->15|32->15|32->15|32->15|32->15|32->15|32->15|33->16|34->17|34->17|35->18|35->18|35->18|36->19|36->19|37->20|37->20|37->20|38->21|38->21|43->26|43->26|45->28|45->28|45->28|45->28|45->28|45->28|52->35|52->35|53->36|53->36|53->36|53->36|53->36|69->52|69->52|78->61|78->61|78->61|78->61|78->61|78->61|84->67|85->68|86->69|86->69|86->69|86->69|87->70|87->70|87->70|89->72|89->72|90->73|91->74|91->74
                  -- GENERATED --
              */
          