
package gitbucket.core.wiki.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object history extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template5[Option[String],List[gitbucket.core.util.JGitUtil.CommitInfo],gitbucket.core.service.RepositoryService.RepositoryInfo,Boolean,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(pageName: Option[String],
  commits: List[gitbucket.core.util.JGitUtil.CommitInfo],
  repository: gitbucket.core.service.RepositoryService.RepositoryInfo,
  isEditable: Boolean)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*5.2*/import gitbucket.core.view.helpers


Seq[Any](_display_(/*6.2*/gitbucket/*6.11*/.core.html.main(s"History - ${repository.owner}/${repository.name}", Some(repository))/*6.97*/{_display_(Seq[Any](format.raw/*6.98*/("""
  """),_display_(/*7.4*/gitbucket/*7.13*/.core.html.menu("wiki", repository)/*7.48*/{_display_(Seq[Any](format.raw/*7.49*/("""
    """),_display_(if(isEditable)/*8.20*/ {_display_(Seq[Any](format.raw/*8.22*/("""
      """),format.raw/*9.7*/("""<div class="pull-right">
        """),_display_(if(pageName.isEmpty)/*10.30*/ {_display_(Seq[Any](format.raw/*10.32*/("""
          """),format.raw/*11.11*/("""<a class="btn" href=""""),_display_(/*11.33*/helpers/*11.40*/.url(repository)),format.raw/*11.56*/("""/wiki/_new">New Page</a>
        """)))}else/*12.16*/{_display_(Seq[Any](format.raw/*12.17*/("""
          """),format.raw/*13.11*/("""<a class="btn btn-default" href=""""),_display_(/*13.45*/helpers/*13.52*/.url(repository)),format.raw/*13.68*/("""/wiki/"""),_display_(/*13.75*/helpers/*13.82*/.urlEncode(pageName)),format.raw/*13.102*/("""/_edit">Edit Page</a>
          <a class="btn btn-success" href=""""),_display_(/*14.45*/helpers/*14.52*/.url(repository)),format.raw/*14.68*/("""/wiki/_new">New Page</a>
        """)))}),format.raw/*15.10*/("""
      """),format.raw/*16.7*/("""</div>
    """)))} else {null} ),format.raw/*17.6*/("""
    """),format.raw/*18.5*/("""<h1 class="body-title">
    """),_display_(if(pageName.isEmpty)/*19.26*/{_display_(Seq[Any](format.raw/*19.27*/("""
      """),format.raw/*20.7*/("""<span class="muted">History</span>
    """)))}else/*21.12*/{_display_(Seq[Any](format.raw/*21.13*/("""
      """),format.raw/*22.7*/("""<span class="muted">History for</span> """),_display_(/*22.47*/pageName/*22.55*/.get),format.raw/*22.59*/("""
    """)))}),format.raw/*23.6*/("""
    """),format.raw/*24.5*/("""</h1>
    <table class="table table-bordered">
      <thead>
        <tr>
          <th colspan="3">
            <div class="pull-left" style="padding-top: 4px;">Revisions</div>
            <div class="pull-right">
              <input type="button" id="compare" value="Compare Revisions" class="btn btn-sm btn-default"/>
            </div>
          </th>
        </tr>
      </thead>
      <tbody>
      """),_display_(/*37.8*/commits/*37.15*/.map/*37.19*/ { commit =>_display_(Seq[Any](format.raw/*37.31*/("""
        """),format.raw/*38.9*/("""<tr>
          <td style="width: 32px; text-align: center ;"><input type="checkbox" name="commitId" value=""""),_display_(/*39.104*/commit/*39.110*/.id),format.raw/*39.113*/("""" aria-label="Revision"></td>
          <td style="width: 200px;">"""),_display_(/*40.38*/helpers/*40.45*/.avatarLink(commit, 20)),format.raw/*40.68*/("""&nbsp;"""),_display_(/*40.75*/helpers/*40.82*/.user(commit.authorName, commit.authorEmailAddress)),format.raw/*40.133*/("""</td>
          <td>
            <span class="muted">"""),_display_(/*42.34*/gitbucket/*42.43*/.core.helper.html.datetimeago(commit.authorTime)),format.raw/*42.91*/(""":</span>&nbsp;"""),_display_(/*42.106*/commit/*42.112*/.shortMessage),format.raw/*42.125*/("""
          """),format.raw/*43.11*/("""</td>
        </tr>
      """)))}),format.raw/*45.8*/("""
      """),format.raw/*46.7*/("""</tbody>
    </table>
    <script>
    $(function()"""),format.raw/*49.17*/("""{"""),format.raw/*49.18*/("""
      """),format.raw/*50.7*/("""$('input[name=commitId]').click(function()"""),format.raw/*50.49*/("""{"""),format.raw/*50.50*/("""
        """),format.raw/*51.9*/("""return !($('input[name=commitId]:checked').length == 3);
      """),format.raw/*52.7*/("""}"""),format.raw/*52.8*/(""");

      $('#compare').click(function()"""),format.raw/*54.37*/("""{"""),format.raw/*54.38*/("""
        """),format.raw/*55.9*/("""var e = $('input[name=commitId]:checked');
        if(e.length == 2)"""),format.raw/*56.26*/("""{"""),format.raw/*56.27*/("""
          """),_display_(if(pageName.isEmpty)/*57.32*/{_display_(Seq[Any](format.raw/*57.33*/("""
            """),format.raw/*58.13*/("""location.href = '"""),_display_(/*58.31*/helpers/*58.38*/.url(repository)),format.raw/*58.54*/("""/wiki/_compare/' +
              $(e.get(1)).attr('value') + '...' + $(e.get(0)).attr('value');
          """)))}else/*60.18*/{_display_(Seq[Any](format.raw/*60.19*/("""
            """),format.raw/*61.13*/("""location.href = '"""),_display_(/*61.31*/helpers/*61.38*/.url(repository)),format.raw/*61.54*/("""/wiki/"""),_display_(/*61.61*/helpers/*61.68*/.urlEncode(pageName.get)),format.raw/*61.92*/("""/_compare/' +
              $(e.get(1)).attr('value') + '...' + $(e.get(0)).attr('value');
          """)))}),format.raw/*63.12*/("""
        """),format.raw/*64.9*/("""}"""),format.raw/*64.10*/("""
      """),format.raw/*65.7*/("""}"""),format.raw/*65.8*/(""");

      $('#top').click(function()"""),format.raw/*67.33*/("""{"""),format.raw/*67.34*/("""
        """),format.raw/*68.9*/("""$('html,body').animate("""),format.raw/*68.32*/("""{"""),format.raw/*68.33*/(""" """),format.raw/*68.34*/("""scrollTop: 0 """),format.raw/*68.47*/("""}"""),format.raw/*68.48*/(""", 'fast');
      """),format.raw/*69.7*/("""}"""),format.raw/*69.8*/(""");
    """),format.raw/*70.5*/("""}"""),format.raw/*70.6*/(""");
    </script>
  """)))}),format.raw/*72.4*/("""
""")))}),format.raw/*73.2*/("""
"""))
      }
    }
  }

  def render(pageName:Option[String],commits:List[gitbucket.core.util.JGitUtil.CommitInfo],repository:gitbucket.core.service.RepositoryService.RepositoryInfo,isEditable:Boolean,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(pageName,commits,repository,isEditable)(context)

  def f:((Option[String],List[gitbucket.core.util.JGitUtil.CommitInfo],gitbucket.core.service.RepositoryService.RepositoryInfo,Boolean) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (pageName,commits,repository,isEditable) => (context) => apply(pageName,commits,repository,isEditable)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/wiki/history.scala.html
                  HASH: 9a02fed99e0da5ac88a7501e401004e14408c6bc
                  MATRIX: 734->1|1038->234|1101->270|1118->279|1212->365|1250->366|1279->370|1296->379|1339->414|1377->415|1423->435|1462->437|1495->444|1576->498|1616->500|1655->511|1704->533|1720->540|1757->556|1814->596|1853->597|1892->608|1953->642|1969->649|2006->665|2040->672|2056->679|2098->699|2191->765|2207->772|2244->788|2309->822|2343->829|2398->841|2430->846|2506->895|2545->896|2579->903|2642->949|2681->950|2715->957|2782->997|2799->1005|2824->1009|2860->1015|2892->1020|3325->1427|3341->1434|3354->1438|3404->1450|3440->1459|3576->1567|3592->1573|3617->1576|3711->1643|3727->1650|3771->1673|3805->1680|3821->1687|3894->1738|3975->1792|3993->1801|4062->1849|4105->1864|4121->1870|4156->1883|4195->1894|4252->1921|4286->1928|4365->1979|4394->1980|4428->1987|4498->2029|4527->2030|4563->2039|4653->2102|4681->2103|4749->2143|4778->2144|4814->2153|4910->2221|4939->2222|4998->2254|5037->2255|5078->2268|5123->2286|5139->2293|5176->2309|5306->2422|5345->2423|5386->2436|5431->2454|5447->2461|5484->2477|5518->2484|5534->2491|5579->2515|5712->2617|5748->2626|5777->2627|5811->2634|5839->2635|5903->2671|5932->2672|5968->2681|6019->2704|6048->2705|6077->2706|6118->2719|6147->2720|6191->2737|6219->2738|6253->2745|6281->2746|6331->2766|6363->2768
                  LINES: 14->1|20->5|23->6|23->6|23->6|23->6|24->7|24->7|24->7|24->7|25->8|25->8|26->9|27->10|27->10|28->11|28->11|28->11|28->11|29->12|29->12|30->13|30->13|30->13|30->13|30->13|30->13|30->13|31->14|31->14|31->14|32->15|33->16|34->17|35->18|36->19|36->19|37->20|38->21|38->21|39->22|39->22|39->22|39->22|40->23|41->24|54->37|54->37|54->37|54->37|55->38|56->39|56->39|56->39|57->40|57->40|57->40|57->40|57->40|57->40|59->42|59->42|59->42|59->42|59->42|59->42|60->43|62->45|63->46|66->49|66->49|67->50|67->50|67->50|68->51|69->52|69->52|71->54|71->54|72->55|73->56|73->56|74->57|74->57|75->58|75->58|75->58|75->58|77->60|77->60|78->61|78->61|78->61|78->61|78->61|78->61|78->61|80->63|81->64|81->64|82->65|82->65|84->67|84->67|85->68|85->68|85->68|85->68|85->68|85->68|86->69|86->69|87->70|87->70|89->72|90->73
                  -- GENERATED --
              */
          