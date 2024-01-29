
package gitbucket.core.repo.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object guide extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[gitbucket.core.service.RepositoryService.RepositoryInfo,Boolean,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(repository: gitbucket.core.service.RepositoryService.RepositoryInfo,
  hasWritePermission: Boolean)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*3.2*/import gitbucket.core.view.helpers


Seq[Any](_display_(/*4.2*/gitbucket/*4.11*/.core.html.main(s"${repository.owner}/${repository.name}", Some(repository))/*4.87*/ {_display_(Seq[Any](format.raw/*4.89*/("""
  """),_display_(/*5.4*/gitbucket/*5.13*/.core.html.menu("files", repository)/*5.49*/{_display_(Seq[Any](format.raw/*5.50*/("""
    """),_display_(if(!hasWritePermission)/*6.29*/{_display_(Seq[Any](format.raw/*6.30*/("""
      """),format.raw/*7.7*/("""<h3>This is an empty repository</h3>
    """)))}else/*8.12*/{_display_(Seq[Any](format.raw/*8.13*/("""
      """),format.raw/*9.7*/("""<h3><strong>Quick setup</strong> — if you've done this kind of thing before</h3>
      <div class="empty-repo-options">
        via <a href=""""),_display_(/*11.23*/repository/*11.33*/.httpUrl),format.raw/*11.41*/("""" class="git-protocol-selector">HTTP</a>
      """),_display_(/*12.8*/repository/*12.18*/.sshUrl.map/*12.29*/ { sshUrl =>_display_(Seq[Any](format.raw/*12.41*/("""
         """),format.raw/*13.10*/("""or
         <a href=""""),_display_(/*14.20*/sshUrl),format.raw/*14.26*/("""" class="git-protocol-selector">SSH</a>
      """)))}),format.raw/*15.8*/("""
      """),format.raw/*16.7*/("""</div>
      <h3 style="margin-top: 30px;">Create a new repository from the command line</h3>
      """),_display_(/*18.8*/helpers/*18.15*/.pre/*18.19*/ {_display_(Seq[Any](format.raw/*18.21*/("""
        """),format.raw/*19.9*/("""touch README.md
        git init
        git add README.md
        git commit -m "first commit"
        git remote add origin <span class="live-clone-url">"""),_display_(/*23.61*/repository/*23.71*/.httpUrl),format.raw/*23.79*/("""</span>
        git push -u origin """),_display_(/*24.29*/context/*24.36*/.settings.defaultBranch),format.raw/*24.59*/("""
      """)))}),format.raw/*25.8*/("""
      """),format.raw/*26.7*/("""<h3 style="margin-top: 30px;">Push an existing repository from the command line</h3>
      """),_display_(/*27.8*/helpers/*27.15*/.pre/*27.19*/ {_display_(Seq[Any](format.raw/*27.21*/("""
        """),format.raw/*28.9*/("""git remote add origin <span class="live-clone-url">"""),_display_(/*28.61*/repository/*28.71*/.httpUrl),format.raw/*28.79*/("""</span>
        git push -u origin """),_display_(/*29.29*/context/*29.36*/.settings.defaultBranch),format.raw/*29.59*/("""
      """)))}),format.raw/*30.8*/("""
      """),format.raw/*31.7*/("""<script>
      $(function()"""),format.raw/*32.19*/("""{"""),format.raw/*32.20*/("""
        """),format.raw/*33.9*/("""$('.git-protocol-selector').click(function(e)"""),format.raw/*33.54*/("""{"""),format.raw/*33.55*/("""
          """),format.raw/*34.11*/("""e.preventDefault();
          $('.live-clone-url').text($(e.target).attr('href'));
        """),format.raw/*36.9*/("""}"""),format.raw/*36.10*/(""");
      """),format.raw/*37.7*/("""}"""),format.raw/*37.8*/(""");
      </script>
    """)))}),format.raw/*39.6*/("""
  """)))}),format.raw/*40.4*/("""
""")))}),format.raw/*41.2*/("""
"""))
      }
    }
  }

  def render(repository:gitbucket.core.service.RepositoryService.RepositoryInfo,hasWritePermission:Boolean,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(repository,hasWritePermission)(context)

  def f:((gitbucket.core.service.RepositoryService.RepositoryInfo,Boolean) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (repository,hasWritePermission) => (context) => apply(repository,hasWritePermission)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/repo/guide.scala.html
                  HASH: be762bae2e0834431a32e3f47a4cce105d738766
                  MATRIX: 671->1|897->156|960->192|977->201|1061->277|1100->279|1129->283|1146->292|1190->328|1228->329|1283->358|1321->359|1354->366|1418->414|1456->415|1489->422|1658->564|1677->574|1706->582|1780->630|1799->640|1819->651|1869->663|1907->673|1956->695|1983->701|2060->748|2094->755|2221->856|2237->863|2250->867|2290->869|2326->878|2509->1034|2528->1044|2557->1052|2620->1088|2636->1095|2680->1118|2718->1126|2752->1133|2870->1225|2886->1232|2899->1236|2939->1238|2975->1247|3054->1299|3073->1309|3102->1317|3165->1353|3181->1360|3225->1383|3263->1391|3297->1398|3352->1425|3381->1426|3417->1435|3490->1480|3519->1481|3558->1492|3676->1583|3705->1584|3741->1593|3769->1594|3823->1618|3857->1622|3889->1624
                  LINES: 14->1|18->3|21->4|21->4|21->4|21->4|22->5|22->5|22->5|22->5|23->6|23->6|24->7|25->8|25->8|26->9|28->11|28->11|28->11|29->12|29->12|29->12|29->12|30->13|31->14|31->14|32->15|33->16|35->18|35->18|35->18|35->18|36->19|40->23|40->23|40->23|41->24|41->24|41->24|42->25|43->26|44->27|44->27|44->27|44->27|45->28|45->28|45->28|45->28|46->29|46->29|46->29|47->30|48->31|49->32|49->32|50->33|50->33|50->33|51->34|53->36|53->36|54->37|54->37|56->39|57->40|58->41
                  -- GENERATED --
              */
          