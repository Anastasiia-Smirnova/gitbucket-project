
package gitbucket.core.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object menu extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template7[String,gitbucket.core.service.RepositoryService.RepositoryInfo,Option[String],Option[Any],Option[Any],Html,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(active: String,
  repository: gitbucket.core.service.RepositoryService.RepositoryInfo,
  id: Option[String] = None,
  info: Option[Any] = None,
  error: Option[Any] = None)(body: Html)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*6.2*/import gitbucket.core.view.helpers

def /*8.2*/menuitem/*8.10*/(path: String, name: String, label: String, icon: String, count: Int = 0):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*8.87*/("""
  """),format.raw/*9.3*/("""<li class = "menu-item-hover """),_display_(if(active == name)/*9.51*/{_display_(Seq[Any](format.raw/*9.52*/("""active""")))} else {null} ),format.raw/*9.59*/("""">
    """),_display_(if(path.startsWith("http"))/*10.33*/{_display_(Seq[Any](format.raw/*10.34*/("""
      """),format.raw/*11.7*/("""<a href=""""),_display_(/*11.17*/path),format.raw/*11.21*/("""" target="_blank">
        <i class="menu-icon octicon octicon-"""),_display_(/*12.46*/icon),format.raw/*12.50*/(""""></i>
        <span>"""),_display_(/*13.16*/label),format.raw/*13.21*/("""</span>
        """),_display_(if(count > 0)/*14.23*/{_display_(Seq[Any](format.raw/*14.24*/("""
          """),format.raw/*15.11*/("""<span class="pull-right-container"><span class="label label-primary pull-right-container">"""),_display_(/*15.102*/count),format.raw/*15.107*/("""</span></span>
        """)))} else {null} ),format.raw/*16.10*/("""
      """),format.raw/*17.7*/("""</a>
    """)))}else/*18.12*/{_display_(Seq[Any](format.raw/*18.13*/("""
      """),format.raw/*19.7*/("""<a href=""""),_display_(/*19.17*/helpers/*19.24*/.url(repository)),_display_(/*19.41*/path),format.raw/*19.45*/("""">
        <i class="menu-icon octicon octicon-"""),_display_(/*20.46*/icon),format.raw/*20.50*/(""""></i>
        <span>"""),_display_(/*21.16*/label),format.raw/*21.21*/("""</span>
        """),_display_(if(count > 0)/*22.23*/ {_display_(Seq[Any](format.raw/*22.25*/("""
          """),format.raw/*23.11*/("""<span class="pull-right-container"><span class="label label-primary pull-right">"""),_display_(/*23.92*/count),format.raw/*23.97*/("""</span></span>
        """)))} else {null} ),format.raw/*24.10*/("""
      """),format.raw/*25.7*/("""</a>
    """)))}),format.raw/*26.6*/("""
  """),format.raw/*27.3*/("""</li>
""")))};
Seq[Any](format.raw/*7.1*/("""
"""),format.raw/*28.2*/("""

"""),format.raw/*30.1*/("""<div class="main-sidebar">
  <div class="sidebar">
    <ul class="sidebar-menu">
      """),_display_(/*33.8*/menuitem("", "files", "Files", "code")),format.raw/*33.46*/("""
      """),_display_(if(repository.branchList.nonEmpty)/*34.42*/ {_display_(Seq[Any](format.raw/*34.44*/("""
        """),_display_(/*35.10*/menuitem("/branches", "branches", "Branches", "git-branch", repository.branchList.length)),format.raw/*35.99*/("""
      """)))} else {null} ),format.raw/*36.8*/("""
      """),_display_(/*37.8*/menuitem("/releases", "releases", "Releases", "tag", repository.tags.length)),format.raw/*37.84*/("""
      """),_display_(if(repository.repository.options.issuesOption != "DISABLE")/*38.67*/ {_display_(Seq[Any](format.raw/*38.69*/("""
        """),_display_(/*39.10*/menuitem("/issues", "issues", "Issues", "issue-opened", repository.issueCount)),format.raw/*39.88*/("""
        """),_display_(/*40.10*/menuitem("/pulls", "pulls", "Pull requests", "git-pull-request", repository.pullCount)),format.raw/*40.96*/("""
        """),_display_(/*41.10*/menuitem("/issues/labels", "labels", "Labels", "tag")),format.raw/*41.63*/("""
        """),_display_(/*42.10*/menuitem("/issues/priorities", "priorities", "Priorities", "flame")),format.raw/*42.77*/("""
        """),_display_(/*43.10*/menuitem("/issues/milestones", "milestones", "Milestones", "milestone", repository.milestoneCount)),format.raw/*43.108*/("""
      """)))}else/*44.14*/{_display_(Seq[Any](format.raw/*44.15*/("""
        """),_display_(/*45.10*/repository/*45.20*/.repository.options.externalIssuesUrl.map/*45.61*/ { externalIssuesUrl =>_display_(Seq[Any](format.raw/*45.84*/("""
          """),_display_(/*46.12*/menuitem(externalIssuesUrl, "issues", "Issues", "issue-opened")),format.raw/*46.75*/("""
        """)))}),format.raw/*47.10*/("""
      """)))}),format.raw/*48.8*/("""
      """),_display_(if(repository.repository.options.wikiOption != "DISABLE")/*49.65*/ {_display_(Seq[Any](format.raw/*49.67*/("""
        """),_display_(/*50.10*/menuitem("/wiki", "wiki", "Wiki", "book")),format.raw/*50.51*/("""
      """)))}else/*51.14*/{_display_(Seq[Any](format.raw/*51.15*/("""
        """),_display_(/*52.10*/repository/*52.20*/.repository.options.externalWikiUrl.map/*52.59*/ { externalWikiUrl =>_display_(Seq[Any](format.raw/*52.80*/("""
          """),_display_(/*53.12*/menuitem(externalWikiUrl, "wiki", "Wiki", "book")),format.raw/*53.61*/("""
        """)))}),format.raw/*54.10*/("""
      """)))}),format.raw/*55.8*/("""
      """),_display_(/*56.8*/gitbucket/*56.17*/.core.plugin.PluginRegistry().getRepositoryMenus.map/*56.69*/ { menu =>_display_(Seq[Any](format.raw/*56.79*/("""
        """),_display_(/*57.10*/menu(repository, context)/*57.35*/.map/*57.39*/ { link =>_display_(Seq[Any](format.raw/*57.49*/("""
          """),_display_(/*58.12*/menuitem(link.path, link.id, link.label, link.icon.getOrElse("ruby"))),format.raw/*58.81*/("""
        """)))}),format.raw/*59.10*/("""
      """)))}),format.raw/*60.8*/("""
      """),_display_(if(context.loginAccount.isDefined && (context.loginAccount.get.isAdmin || repository.managers.contains(context.loginAccount.get.userName)))/*61.147*/{_display_(Seq[Any](format.raw/*61.148*/("""
        """),_display_(/*62.10*/menuitem("/settings", "settings", "Settings", "gear")),format.raw/*62.63*/("""
      """)))} else {null} ),format.raw/*63.8*/("""
    """),format.raw/*64.5*/("""</ul>
  </div>
</div>
<div class="content-wrapper">
  <div class="content body clearfix">
    <div class="headbar">
      <div class="container">
        """),_display_(/*71.10*/gitbucket/*71.19*/.core.helper.html.information(info)),format.raw/*71.54*/("""
        """),_display_(/*72.10*/gitbucket/*72.19*/.core.helper.html.error(error)),format.raw/*72.49*/("""
        """),format.raw/*73.9*/("""<div class="head">
          <div class="pull-right">
            """),_display_(/*75.14*/gitbucket/*75.23*/.core.plugin.PluginRegistry().getRepositoryHeaders.map/*75.77*/ { repositoryHeaderComponent =>_display_(Seq[Any](format.raw/*75.108*/("""
              """),_display_(/*76.16*/repositoryHeaderComponent(repository, context)),format.raw/*76.62*/("""
            """)))}),format.raw/*77.14*/("""
            """),_display_(if(repository.repository.options.allowFork && (context.settings.basicBehavior.repositoryOperation.fork || context.loginAccount.map(_.isAdmin).getOrElse(false)))/*78.174*/ {_display_(Seq[Any](format.raw/*78.176*/("""
              """),_display_(if(context.loginAccount.isEmpty)/*79.48*/{_display_(Seq[Any](format.raw/*79.49*/("""
                """),format.raw/*80.17*/("""<a class="btn btn-default btn-sm" href=""""),_display_(/*80.58*/context/*80.65*/.path),format.raw/*80.70*/("""/signin?redirect="""),_display_(/*80.88*/helpers/*80.95*/.urlEncode(s"${context.path}/${repository.owner}/${repository.name}")),format.raw/*80.164*/("""">
                  <span class="strong"><i class="octicon octicon-repo-forked"></i>Fork</span><span class="muted">: """),_display_(/*81.117*/repository/*81.127*/.forkedCount),format.raw/*81.139*/("""</span>
                </a>
              """)))}else/*83.22*/{_display_(Seq[Any](format.raw/*83.23*/("""
                """),format.raw/*84.17*/("""<a class="btn btn-default btn-sm" href=""""),_display_(/*84.58*/context/*84.65*/.path),format.raw/*84.70*/("""/"""),_display_(/*84.72*/repository/*84.82*/.owner),format.raw/*84.88*/("""/"""),_display_(/*84.90*/repository/*84.100*/.name),format.raw/*84.105*/("""/fork" rel="facebox">
                  <span class="strong"><i class="octicon octicon-repo-forked"></i>Fork</span><span class="muted">: """),_display_(/*85.117*/repository/*85.127*/.forkedCount),format.raw/*85.139*/("""</span>
                </a>
              """)))}),format.raw/*87.16*/("""
            """)))} else {null} ),format.raw/*88.14*/("""
            """),format.raw/*89.13*/("""<form id="fork-form" method="post" action=""""),_display_(/*89.57*/context/*89.64*/.path),format.raw/*89.69*/("""/"""),_display_(/*89.71*/repository/*89.81*/.owner),format.raw/*89.87*/("""/"""),_display_(/*89.89*/repository/*89.99*/.name),format.raw/*89.104*/("""/fork" style="display: none;">
              <input type="hidden" name="account" value=""""),_display_(/*90.59*/context/*90.66*/.loginAccount.map(_.userName)),format.raw/*90.95*/(""""/>
            </form>
          </div>
          """),_display_(/*93.12*/gitbucket/*93.21*/.core.helper.html.repositoryicon(repository, true)),format.raw/*93.71*/("""
          """),format.raw/*94.11*/("""<a href=""""),_display_(/*94.21*/helpers/*94.28*/.url(repository.owner)),format.raw/*94.50*/("""">"""),_display_(/*94.53*/repository/*94.63*/.owner),format.raw/*94.69*/("""</a> / <a href=""""),_display_(/*94.86*/helpers/*94.93*/.url(repository)),format.raw/*94.109*/("""" class="strong">"""),_display_(/*94.127*/repository/*94.137*/.name),format.raw/*94.142*/("""</a>

          """),_display_(/*96.12*/defining(repository.repository)/*96.43*/{ x =>_display_(Seq[Any](format.raw/*96.49*/("""
            """),_display_(if(repository.repository.originRepositoryName.isDefined)/*97.70*/{_display_(Seq[Any](format.raw/*97.71*/("""
              """),format.raw/*98.15*/("""<div class="forked">
                forked from <a href=""""),_display_(/*99.39*/context/*99.46*/.path),format.raw/*99.51*/("""/"""),_display_(/*99.53*/x/*99.54*/.parentUserName),format.raw/*99.69*/("""/"""),_display_(/*99.71*/x/*99.72*/.parentRepositoryName),format.raw/*99.93*/("""">"""),_display_(/*99.96*/x/*99.97*/.parentUserName),format.raw/*99.112*/("""/"""),_display_(/*99.114*/x/*99.115*/.parentRepositoryName),format.raw/*99.136*/("""</a>
              </div>
            """)))} else {null} ),format.raw/*101.14*/("""
          """)))}),format.raw/*102.12*/("""
        """),format.raw/*103.9*/("""</div>
      </div>
    </div>
    """),_display_(/*106.6*/body),format.raw/*106.10*/("""
  """),format.raw/*107.3*/("""</div>
</div>
<script>
$(function()"""),format.raw/*110.13*/("""{"""),format.raw/*110.14*/("""
  """),format.raw/*111.3*/("""$('a[rel*=facebox]').facebox("""),format.raw/*111.32*/("""{"""),format.raw/*111.33*/("""
    """),format.raw/*112.5*/("""'loadingImage': '"""),_display_(/*112.23*/helpers/*112.30*/.assets("/vendors/facebox/loading.gif")),format.raw/*112.69*/("""',
    'closeImage': '"""),_display_(/*113.21*/helpers/*113.28*/.assets("/vendors/facebox/closelabel.png")),format.raw/*113.70*/("""'
  """),format.raw/*114.3*/("""}"""),format.raw/*114.4*/(""");

  $(document).on("click", ".js-fork-owner-select-target", function() """),format.raw/*116.70*/("""{"""),format.raw/*116.71*/("""
    """),format.raw/*117.5*/("""var account = $(this).text().replace("@", "");
    $("#account").val(account);
    $("#fork").submit();
  """),format.raw/*120.3*/("""}"""),format.raw/*120.4*/(""");
"""),format.raw/*121.1*/("""}"""),format.raw/*121.2*/(""");
</script>


"""))
      }
    }
  }

  def render(active:String,repository:gitbucket.core.service.RepositoryService.RepositoryInfo,id:Option[String],info:Option[Any],error:Option[Any],body:Html,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(active,repository,id,info,error)(body)(context)

  def f:((String,gitbucket.core.service.RepositoryService.RepositoryInfo,Option[String],Option[Any],Option[Any]) => (Html) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (active,repository,id,info,error) => (body) => (context) => apply(active,repository,id,info,error)(body)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/menu.scala.html
                  HASH: 92bd4e05e8bfe6fef8da7a4d765b2cb5d445e49c
                  MATRIX: 708->1|1019->241|1066->278|1082->286|1235->363|1264->366|1338->414|1376->415|1426->422|1488->457|1527->458|1561->465|1598->475|1623->479|1714->543|1739->547|1788->569|1814->574|1871->604|1910->605|1949->616|2068->707|2095->712|2163->736|2197->743|2230->759|2269->760|2303->767|2340->777|2356->784|2393->801|2418->805|2493->853|2518->857|2567->879|2593->884|2650->914|2690->916|2729->927|2837->1008|2863->1013|2931->1037|2965->1044|3005->1054|3035->1057|3080->276|3108->1064|3137->1066|3251->1154|3310->1192|3379->1234|3419->1236|3456->1246|3566->1335|3617->1343|3651->1351|3748->1427|3842->1494|3882->1496|3919->1506|4018->1584|4055->1594|4162->1680|4199->1690|4273->1743|4310->1753|4398->1820|4435->1830|4555->1928|4586->1942|4625->1943|4662->1953|4681->1963|4731->2004|4792->2027|4831->2039|4915->2102|4956->2112|4994->2120|5086->2185|5126->2187|5163->2197|5225->2238|5256->2252|5295->2253|5332->2263|5351->2273|5399->2312|5458->2333|5497->2345|5567->2394|5608->2404|5646->2412|5680->2420|5698->2429|5759->2481|5807->2491|5844->2501|5878->2526|5891->2530|5939->2540|5978->2552|6068->2621|6109->2631|6147->2639|6322->2786|6362->2787|6399->2797|6473->2850|6524->2858|6556->2863|6738->3018|6756->3027|6812->3062|6849->3072|6867->3081|6918->3111|6954->3120|7048->3187|7066->3196|7129->3250|7199->3281|7242->3297|7309->3343|7354->3357|7556->3531|7597->3533|7672->3581|7711->3582|7756->3599|7824->3640|7840->3647|7866->3652|7911->3670|7927->3677|8018->3746|8165->3865|8185->3875|8219->3887|8286->3937|8325->3938|8370->3955|8438->3996|8454->4003|8480->4008|8509->4010|8528->4020|8555->4026|8584->4028|8604->4038|8631->4043|8797->4181|8817->4191|8851->4203|8926->4247|8984->4261|9025->4274|9096->4318|9112->4325|9138->4330|9167->4332|9186->4342|9213->4348|9242->4350|9261->4360|9288->4365|9404->4454|9420->4461|9470->4490|9549->4542|9567->4551|9638->4601|9677->4612|9714->4622|9730->4629|9773->4651|9803->4654|9822->4664|9849->4670|9893->4687|9909->4694|9947->4710|9993->4728|10013->4738|10040->4743|10084->4760|10124->4791|10168->4797|10265->4867|10304->4868|10347->4883|10433->4942|10449->4949|10475->4954|10504->4956|10514->4957|10550->4972|10579->4974|10589->4975|10631->4996|10661->4999|10671->5000|10708->5015|10738->5017|10749->5018|10792->5039|10876->5078|10920->5090|10957->5099|11020->5135|11046->5139|11077->5142|11141->5177|11171->5178|11202->5181|11260->5210|11290->5211|11323->5216|11369->5234|11386->5241|11447->5280|11498->5303|11515->5310|11579->5352|11611->5356|11640->5357|11742->5430|11772->5431|11805->5436|11939->5543|11968->5544|11999->5547|12028->5548
                  LINES: 14->1|21->6|23->8|23->8|25->8|26->9|26->9|26->9|26->9|27->10|27->10|28->11|28->11|28->11|29->12|29->12|30->13|30->13|31->14|31->14|32->15|32->15|32->15|33->16|34->17|35->18|35->18|36->19|36->19|36->19|36->19|36->19|37->20|37->20|38->21|38->21|39->22|39->22|40->23|40->23|40->23|41->24|42->25|43->26|44->27|46->7|47->28|49->30|52->33|52->33|53->34|53->34|54->35|54->35|55->36|56->37|56->37|57->38|57->38|58->39|58->39|59->40|59->40|60->41|60->41|61->42|61->42|62->43|62->43|63->44|63->44|64->45|64->45|64->45|64->45|65->46|65->46|66->47|67->48|68->49|68->49|69->50|69->50|70->51|70->51|71->52|71->52|71->52|71->52|72->53|72->53|73->54|74->55|75->56|75->56|75->56|75->56|76->57|76->57|76->57|76->57|77->58|77->58|78->59|79->60|80->61|80->61|81->62|81->62|82->63|83->64|90->71|90->71|90->71|91->72|91->72|91->72|92->73|94->75|94->75|94->75|94->75|95->76|95->76|96->77|97->78|97->78|98->79|98->79|99->80|99->80|99->80|99->80|99->80|99->80|99->80|100->81|100->81|100->81|102->83|102->83|103->84|103->84|103->84|103->84|103->84|103->84|103->84|103->84|103->84|103->84|104->85|104->85|104->85|106->87|107->88|108->89|108->89|108->89|108->89|108->89|108->89|108->89|108->89|108->89|108->89|109->90|109->90|109->90|112->93|112->93|112->93|113->94|113->94|113->94|113->94|113->94|113->94|113->94|113->94|113->94|113->94|113->94|113->94|113->94|115->96|115->96|115->96|116->97|116->97|117->98|118->99|118->99|118->99|118->99|118->99|118->99|118->99|118->99|118->99|118->99|118->99|118->99|118->99|118->99|118->99|120->101|121->102|122->103|125->106|125->106|126->107|129->110|129->110|130->111|130->111|130->111|131->112|131->112|131->112|131->112|132->113|132->113|132->113|133->114|133->114|135->116|135->116|136->117|139->120|139->120|140->121|140->121
                  -- GENERATED --
              */
          