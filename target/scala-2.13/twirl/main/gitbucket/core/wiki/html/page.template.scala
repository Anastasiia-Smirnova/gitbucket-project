
package gitbucket.core.wiki.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object page extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template8[String,gitbucket.core.service.WikiService.WikiPageInfo,List[String],gitbucket.core.service.RepositoryService.RepositoryInfo,Boolean,Option[gitbucket.core.service.WikiService.WikiPageInfo],Option[gitbucket.core.service.WikiService.WikiPageInfo],gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(pageName: String,
  page: gitbucket.core.service.WikiService.WikiPageInfo,
  pages: List[String],
  repository: gitbucket.core.service.RepositoryService.RepositoryInfo,
  isEditable: Boolean,
  sidebar: Option[gitbucket.core.service.WikiService.WikiPageInfo],
  footer: Option[gitbucket.core.service.WikiService.WikiPageInfo])(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*8.2*/import gitbucket.core.view.helpers
/*9.2*/import gitbucket.core.service.WikiService


Seq[Any](_display_(/*10.2*/gitbucket/*10.11*/.core.html.main(s"${pageName} - ${repository.owner}/${repository.name}", Some(repository))/*10.101*/{_display_(Seq[Any](format.raw/*10.102*/("""
  """),_display_(/*11.4*/gitbucket/*11.13*/.core.html.menu("wiki", repository)/*11.48*/{_display_(Seq[Any](format.raw/*11.49*/("""
    """),format.raw/*12.5*/("""<div>
      <form method="GET" action=""""),_display_(/*13.35*/helpers/*13.42*/.url(repository)),format.raw/*13.58*/("""/search" id="search-filter-form" class="form-inline pull-right">
        <div class="input-group">
          <input type="text" class="form-control" name="q" placeholder="Search..." aria-label="Search all pages"/>
          <input type="hidden" name="type" value="wiki"/>
          <span class="input-group-btn">
            <button type="submit" id="search-btn" class="btn btn-default" aria-label="Search all pages"><i class="fa fa-search"></i></button>
          </span>
        </div>
        <a class="btn btn-default" href=""""),_display_(/*21.43*/helpers/*21.50*/.url(repository)),format.raw/*21.66*/("""/wiki/"""),_display_(/*21.73*/helpers/*21.80*/.urlEncode(pageName)),format.raw/*21.100*/("""/_history">Page History</a>
        """),_display_(if(isEditable)/*22.24*/{_display_(Seq[Any](format.raw/*22.25*/("""
          """),format.raw/*23.11*/("""<a class="btn btn-default" href=""""),_display_(/*23.45*/helpers/*23.52*/.url(repository)),format.raw/*23.68*/("""/wiki/"""),_display_(/*23.75*/helpers/*23.82*/.urlEncode(pageName)),format.raw/*23.102*/("""/_edit">Edit Page</a>
          <a class="btn btn-success" href=""""),_display_(/*24.45*/helpers/*24.52*/.url(repository)),format.raw/*24.68*/("""/wiki/_new">New Page</a>
        """)))} else {null} ),format.raw/*25.10*/("""
      """),format.raw/*26.7*/("""</form>
      <h1 class="body-title">"""),_display_(/*27.31*/pageName),format.raw/*27.39*/("""</h1>
      <div>
        <span class="muted"><strong>"""),_display_(/*29.38*/page/*29.42*/.committer),format.raw/*29.52*/("""</strong> edited this page """),_display_(/*29.80*/gitbucket/*29.89*/.core.helper.html.datetimeago(page.time)),format.raw/*29.129*/("""</span>
      </div>
      <hr>
    </div>
    <div style="width: 250px; margin-top: 20px;" class="pull-right pc">
      """),_display_(/*34.8*/defining(15)/*34.20*/{ max =>_display_(Seq[Any](format.raw/*34.28*/("""
        """),format.raw/*35.9*/("""<div class="panel panel-default">
          <div class="panel-heading strong">
            <a id="show-pages-index" href="javascript:void(0);">
              <span id="triangle-down" class="octicon octicon-triangle-down"></span>
              <span id="triangle-right" class="octicon octicon-triangle-right" style="display: none;"></span>
              <span class="strong">Pages</span> <span class="badge">"""),_display_(/*40.70*/pages/*40.75*/.length),format.raw/*40.82*/("""</span>
            </a>
          </div>
          <ul id="pages-index" class="list-group list-group-flush">
            """),_display_(/*44.14*/pages/*44.19*/.zipWithIndex.map/*44.36*/ { case (page, i) =>_display_(Seq[Any](format.raw/*44.56*/("""
              """),format.raw/*45.15*/("""<li class="list-group-item page-link" style="border: none; """),_display_(if(i > max - 1)/*45.90*/{_display_(Seq[Any](format.raw/*45.91*/("""display:none;""")))} else {null} ),format.raw/*45.105*/("""">
                <a href=""""),_display_(/*46.27*/helpers/*46.34*/.url(repository)),format.raw/*46.50*/("""/wiki/"""),_display_(/*46.57*/helpers/*46.64*/.urlEncode(page)),format.raw/*46.80*/("""" class="strong">"""),_display_(/*46.98*/page),format.raw/*46.102*/("""</a>
              </li>
            """)))}),format.raw/*48.14*/("""
            """),_display_(if(pages.size > max)/*49.34*/{_display_(Seq[Any](format.raw/*49.35*/("""
              """),format.raw/*50.15*/("""<li class="list-group-item show-more">
                <a href="javascript:void(0);" id="show-more-pages">Show more """),_display_(/*51.79*/{pages.size - max}),format.raw/*51.97*/(""" """),format.raw/*51.98*/("""pages...</a>
              </li>
            """)))} else {null} ),format.raw/*53.14*/("""
          """),format.raw/*54.11*/("""</ul>
        </div>
      """)))}),format.raw/*56.8*/("""
      """),_display_(/*57.8*/sidebar/*57.15*/.map/*57.19*/ { sidebarPage =>_display_(Seq[Any](format.raw/*57.36*/("""
        """),format.raw/*58.9*/("""<div class="wiki-sidebar">
          """),_display_(if(isEditable)/*59.26*/{_display_(Seq[Any](format.raw/*59.27*/("""
            """),format.raw/*60.13*/("""<a href=""""),_display_(/*60.23*/helpers/*60.30*/.url(repository)),format.raw/*60.46*/("""/wiki/_Sidebar/_edit" style="text-decoration: none;"><span class="octicon octicon-pencil pull-right"></span></a>
          """)))} else {null} ),format.raw/*61.12*/("""
          """),_display_(/*62.12*/helpers/*62.19*/.markdown(sidebarPage.content, repository, "master", true, false, false, false, pages)),format.raw/*62.105*/("""
        """),format.raw/*63.9*/("""</div>
      """)))}/*64.8*/.getOrElse/*64.18*/{_display_(Seq[Any](format.raw/*64.19*/("""
        """),_display_(if(isEditable)/*65.24*/{_display_(Seq[Any](format.raw/*65.25*/("""
          """),format.raw/*66.11*/("""<a class="button-link" href=""""),_display_(/*66.41*/helpers/*66.48*/.url(repository)),format.raw/*66.64*/("""/wiki/_Sidebar/_edit" style="text-decoration: none;">
            <div class="wiki-sidebar-dotted text-center"><i class="octicon octicon-plus"></i> Add a custom sidebar</div>
          </a>
        """)))} else {null} ),format.raw/*69.10*/("""
      """)))}),format.raw/*70.8*/("""
      """),format.raw/*71.7*/("""<div>
        <strong>Clone this wiki locally</strong>
      </div>
      """),_display_(/*74.8*/gitbucket/*74.17*/.core.helper.html.copy("repository-url", "repository-url-copy", WikiService.wikiHttpUrl(repository))/*74.117*/{_display_(Seq[Any](format.raw/*74.118*/("""
        """),format.raw/*75.9*/("""<input type="text" value=""""),_display_(/*75.36*/WikiService/*75.47*/.wikiHttpUrl(repository)),format.raw/*75.71*/("""" id="repository-url" class="form-control input-sm" readonly aria-label="repository-url">
      """)))}),format.raw/*76.8*/("""
      """),_display_(if(WikiService.wikiSshUrl(repository).isDefined)/*77.56*/ {_display_(Seq[Any](format.raw/*77.58*/("""
        """),format.raw/*78.9*/("""<div class="small">
          <span class="mute">You can clone <a href="javascript:void(0);" id="repository-url-http">HTTP</a> or <a href="javascript:void(0);" id="repository-url-ssh">SSH</a>.</span>
        </div>
      """)))} else {null} ),format.raw/*81.8*/("""
    """),format.raw/*82.5*/("""</div>
    <div class="wiki-main">
      <div class="markdown-body">
        """),_display_(/*85.10*/helpers/*85.17*/.markdown(
          markdown = page.content,
          repository = repository,
          branch = "master",
          enableWikiLink = true,
          enableRefsLink = false,
          enableLineBreaks = false,
          enableTaskList = false,
          hasWritePermission = false,
          pages = pages
        )),format.raw/*95.10*/("""
      """),format.raw/*96.7*/("""</div>
      """),_display_(/*97.8*/footer/*97.14*/.map/*97.18*/ { footerPage =>_display_(Seq[Any](format.raw/*97.34*/("""
        """),format.raw/*98.9*/("""<div class="wiki-sidebar wiki-footer">
          """),_display_(if(isEditable)/*99.26*/{_display_(Seq[Any](format.raw/*99.27*/("""
            """),format.raw/*100.13*/("""<a href=""""),_display_(/*100.23*/helpers/*100.30*/.url(repository)),format.raw/*100.46*/("""/wiki/_Footer/_edit" style="text-decoration: none;"><span class="octicon octicon-pencil pull-right"></span></a>
          """)))} else {null} ),format.raw/*101.12*/("""
          """),_display_(/*102.12*/helpers/*102.19*/.markdown(
            markdown         = footerPage.content,
            repository       = repository,
            branch           = "master",
            enableWikiLink   = true,
            enableRefsLink   = false,
            enableLineBreaks = false,
            enableAnchor     = false,
            pages            = pages
          )),format.raw/*111.12*/("""
        """),format.raw/*112.9*/("""</div>
      """)))}/*113.8*/.getOrElse/*113.18*/{_display_(Seq[Any](format.raw/*113.19*/("""
        """),_display_(if(isEditable)/*114.24*/{_display_(Seq[Any](format.raw/*114.25*/("""
          """),format.raw/*115.11*/("""<a class="button-link" href=""""),_display_(/*115.41*/helpers/*115.48*/.url(repository)),format.raw/*115.64*/("""/wiki/_Footer/_edit" style="text-decoration: none;">
            <div class="wiki-sidebar-dotted text-center"><i class="octicon octicon-plus"></i> Add a custom footer</div>
          </a>
        """)))} else {null} ),format.raw/*118.10*/("""
      """)))}),format.raw/*119.8*/("""
    """),format.raw/*120.5*/("""</div>
  """)))}),format.raw/*121.4*/("""
""")))}),format.raw/*122.2*/("""
"""),format.raw/*123.1*/("""<script>
$(function()"""),format.raw/*124.13*/("""{"""),format.raw/*124.14*/("""
  """),format.raw/*125.3*/("""$('#show-more-pages').click(function(e)"""),format.raw/*125.42*/("""{"""),format.raw/*125.43*/("""
    """),format.raw/*126.5*/("""$('li.page-link').show();
    $(e.target).parents('li.show-more').remove();
  """),format.raw/*128.3*/("""}"""),format.raw/*128.4*/(""");

  $('#show-pages-index').click(function(e)"""),format.raw/*130.43*/("""{"""),format.raw/*130.44*/("""
    """),format.raw/*131.5*/("""if($('#pages-index').is(":visible"))"""),format.raw/*131.41*/("""{"""),format.raw/*131.42*/("""
      """),format.raw/*132.7*/("""$('#triangle-down').hide();
      $('#triangle-right').show();
      $('#pages-index').hide();
    """),format.raw/*135.5*/("""}"""),format.raw/*135.6*/(""" """),format.raw/*135.7*/("""else """),format.raw/*135.12*/("""{"""),format.raw/*135.13*/("""
      """),format.raw/*136.7*/("""$('#triangle-right').hide();
      $('#triangle-down').show();
      $('#pages-index').show();
    """),format.raw/*139.5*/("""}"""),format.raw/*139.6*/("""
  """),format.raw/*140.3*/("""}"""),format.raw/*140.4*/(""");

  """),_display_(/*142.4*/sidebar/*142.11*/.map/*142.15*/ { sidebarPage =>_display_(Seq[Any](format.raw/*142.32*/("""
    """),format.raw/*143.5*/("""$('#pages-index').hide();
    $('#triangle-down').hide();
    $('#triangle-right').show();
  """)))}),format.raw/*146.4*/("""

  """),_display_(/*148.4*/WikiService/*148.15*/.wikiSshUrl(repository).map/*148.42*/ { sshUrl =>_display_(Seq[Any](format.raw/*148.54*/("""
    """),format.raw/*149.5*/("""$('#repository-url-http').click(function()"""),format.raw/*149.47*/("""{"""),format.raw/*149.48*/("""
      """),format.raw/*150.7*/("""$('#repository-url').val('"""),_display_(/*150.34*/WikiService/*150.45*/.wikiHttpUrl(repository)),format.raw/*150.69*/("""');
      $('#repository-url-copy').attr('data-clipboard-text', $('#repository-url').val());
    """),format.raw/*152.5*/("""}"""),format.raw/*152.6*/(""");
    $('#repository-url-ssh').click(function()"""),format.raw/*153.46*/("""{"""),format.raw/*153.47*/("""
      """),format.raw/*154.7*/("""$('#repository-url').val('"""),_display_(/*154.34*/sshUrl),format.raw/*154.40*/("""');
      $('#repository-url-copy').attr('data-clipboard-text', $('#repository-url').val());
    """),format.raw/*156.5*/("""}"""),format.raw/*156.6*/(""");
  """)))}),format.raw/*157.4*/("""
"""),format.raw/*158.1*/("""}"""),format.raw/*158.2*/(""");
</script>
"""))
      }
    }
  }

  def render(pageName:String,page:gitbucket.core.service.WikiService.WikiPageInfo,pages:List[String],repository:gitbucket.core.service.RepositoryService.RepositoryInfo,isEditable:Boolean,sidebar:Option[gitbucket.core.service.WikiService.WikiPageInfo],footer:Option[gitbucket.core.service.WikiService.WikiPageInfo],context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(pageName,page,pages,repository,isEditable,sidebar,footer)(context)

  def f:((String,gitbucket.core.service.WikiService.WikiPageInfo,List[String],gitbucket.core.service.RepositoryService.RepositoryInfo,Boolean,Option[gitbucket.core.service.WikiService.WikiPageInfo],Option[gitbucket.core.service.WikiService.WikiPageInfo]) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (pageName,page,pages,repository,isEditable,sidebar,footer) => (context) => apply(pageName,page,pages,repository,isEditable,sidebar,footer)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/wiki/page.scala.html
                  HASH: 33f652390a55add9e3c33d21812c9464cb6eec10
                  MATRIX: 850->1|1303->383|1345->419|1416->462|1434->471|1534->561|1574->562|1604->566|1622->575|1666->610|1705->611|1737->616|1804->656|1820->663|1857->679|2414->1209|2430->1216|2467->1232|2501->1239|2517->1246|2559->1266|2637->1317|2676->1318|2715->1329|2776->1363|2792->1370|2829->1386|2863->1393|2879->1400|2921->1420|3014->1486|3030->1493|3067->1509|3145->1543|3179->1550|3244->1588|3273->1596|3355->1651|3368->1655|3399->1665|3454->1693|3472->1702|3534->1742|3682->1864|3703->1876|3749->1884|3785->1893|4220->2301|4234->2306|4262->2313|4412->2436|4426->2441|4452->2458|4510->2478|4553->2493|4655->2568|4694->2569|4753->2583|4809->2612|4825->2619|4862->2635|4896->2642|4912->2649|4949->2665|4994->2683|5020->2687|5089->2725|5150->2759|5189->2760|5232->2775|5376->2892|5415->2910|5444->2911|5534->2957|5573->2968|5631->2996|5665->3004|5681->3011|5694->3015|5749->3032|5785->3041|5864->3093|5903->3094|5944->3107|5981->3117|5997->3124|6034->3140|6202->3264|6241->3276|6257->3283|6365->3369|6401->3378|6433->3392|6452->3402|6491->3403|6542->3427|6581->3428|6620->3439|6677->3469|6693->3476|6730->3492|6973->3691|7011->3699|7045->3706|7146->3781|7164->3790|7274->3890|7314->3891|7350->3900|7404->3927|7424->3938|7469->3962|7596->4059|7679->4115|7719->4117|7755->4126|8020->4348|8052->4353|8157->4431|8173->4438|8512->4756|8546->4763|8586->4777|8601->4783|8614->4787|8668->4803|8704->4812|8795->4876|8834->4877|8876->4890|8914->4900|8931->4907|8969->4923|9137->5046|9177->5058|9194->5065|9561->5410|9598->5419|9631->5433|9651->5443|9691->5444|9743->5468|9783->5469|9823->5480|9881->5510|9898->5517|9936->5533|10178->5730|10217->5738|10250->5743|10291->5753|10324->5755|10353->5756|10403->5777|10433->5778|10464->5781|10532->5820|10562->5821|10595->5826|10701->5904|10730->5905|10805->5951|10835->5952|10868->5957|10933->5993|10963->5994|10998->6001|11125->6100|11154->6101|11183->6102|11217->6107|11247->6108|11282->6115|11409->6214|11438->6215|11469->6218|11498->6219|11532->6226|11549->6233|11563->6237|11619->6254|11652->6259|11777->6353|11809->6358|11830->6369|11867->6396|11918->6408|11951->6413|12022->6455|12052->6456|12087->6463|12142->6490|12163->6501|12209->6525|12334->6622|12363->6623|12440->6671|12470->6672|12505->6679|12560->6706|12588->6712|12713->6809|12742->6810|12779->6816|12808->6817|12837->6818
                  LINES: 14->1|23->8|24->9|27->10|27->10|27->10|27->10|28->11|28->11|28->11|28->11|29->12|30->13|30->13|30->13|38->21|38->21|38->21|38->21|38->21|38->21|39->22|39->22|40->23|40->23|40->23|40->23|40->23|40->23|40->23|41->24|41->24|41->24|42->25|43->26|44->27|44->27|46->29|46->29|46->29|46->29|46->29|46->29|51->34|51->34|51->34|52->35|57->40|57->40|57->40|61->44|61->44|61->44|61->44|62->45|62->45|62->45|62->45|63->46|63->46|63->46|63->46|63->46|63->46|63->46|63->46|65->48|66->49|66->49|67->50|68->51|68->51|68->51|70->53|71->54|73->56|74->57|74->57|74->57|74->57|75->58|76->59|76->59|77->60|77->60|77->60|77->60|78->61|79->62|79->62|79->62|80->63|81->64|81->64|81->64|82->65|82->65|83->66|83->66|83->66|83->66|86->69|87->70|88->71|91->74|91->74|91->74|91->74|92->75|92->75|92->75|92->75|93->76|94->77|94->77|95->78|98->81|99->82|102->85|102->85|112->95|113->96|114->97|114->97|114->97|114->97|115->98|116->99|116->99|117->100|117->100|117->100|117->100|118->101|119->102|119->102|128->111|129->112|130->113|130->113|130->113|131->114|131->114|132->115|132->115|132->115|132->115|135->118|136->119|137->120|138->121|139->122|140->123|141->124|141->124|142->125|142->125|142->125|143->126|145->128|145->128|147->130|147->130|148->131|148->131|148->131|149->132|152->135|152->135|152->135|152->135|152->135|153->136|156->139|156->139|157->140|157->140|159->142|159->142|159->142|159->142|160->143|163->146|165->148|165->148|165->148|165->148|166->149|166->149|166->149|167->150|167->150|167->150|167->150|169->152|169->152|170->153|170->153|171->154|171->154|171->154|173->156|173->156|174->157|175->158|175->158
                  -- GENERATED --
              */
          