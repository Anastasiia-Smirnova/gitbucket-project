
package gitbucket.core.settings.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object danger extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[gitbucket.core.service.RepositoryService.RepositoryInfo,Option[Any],gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(repository: gitbucket.core.service.RepositoryService.RepositoryInfo, info: Option[Any])(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*2.2*/import gitbucket.core.view.helpers


Seq[Any](_display_(/*3.2*/gitbucket/*3.11*/.core.html.main("Danger Zone", Some(repository))/*3.59*/{_display_(Seq[Any](format.raw/*3.60*/("""
  """),_display_(/*4.4*/gitbucket/*4.13*/.core.html.menu("settings", repository)/*4.52*/{_display_(Seq[Any](format.raw/*4.53*/("""
    """),_display_(/*5.6*/gitbucket/*5.15*/.core.settings.html.menu("danger", repository)/*5.61*/{_display_(Seq[Any](format.raw/*5.62*/("""
      """),_display_(/*6.8*/gitbucket/*6.17*/.core.helper.html.information(info)),format.raw/*6.52*/("""
      """),format.raw/*7.7*/("""<div class="panel panel-default">
        <div class="panel-heading strong">Danger Zone</div>
        <div class="panel-body">
          <form id="gc-form" method="post" action=""""),_display_(/*10.53*/helpers/*10.60*/.url(repository)),format.raw/*10.76*/("""/settings/gc">
            <fieldset class="form-group">
              <label class="strong">Garbage collection</label>
              <div>
                Run garbage collection for this git repository immediately.
                <input type="submit" class="btn btn-danger pull-right" value="Garbage collection"/>
              </div>
            </fieldset>
          </form>
          """),_display_(if(context.settings.basicBehavior.repositoryOperation.rename || context.loginAccount.get.isAdmin)/*19.109*/{_display_(Seq[Any](format.raw/*19.110*/("""
            """),format.raw/*20.13*/("""<form id="rename-form" method="post" action=""""),_display_(/*20.59*/helpers/*20.66*/.url(repository)),format.raw/*20.82*/("""/settings/rename" validate="true" autocomplete="off">
              <fieldset class="border-top form-group">
                <label class="strong">Rename repository</label>
                <div>
                  Rename this repository. This will make the current URL unavailable.
                  <div class="pull-right">
                    <input type="text" name="repositoryName" id="repositoryName" class="form-control" style="width: 200px; display: inline; vertical-align: middle;" value=""""),_display_(/*26.174*/repository/*26.184*/.name),format.raw/*26.189*/("""" aria-label="Repository name"/>
                    <input type="submit" class="btn btn-danger" value="Rename"/>
                    <div>
                      <span id="error-repositoryName" class="error"></span>
                    </div>
                  </div>
                </div>
              </fieldset>
            </form>
          """)))} else {null} ),format.raw/*35.12*/("""
          """),_display_(if(context.settings.basicBehavior.repositoryOperation.transfer || context.loginAccount.get.isAdmin)/*36.111*/{_display_(Seq[Any](format.raw/*36.112*/("""
            """),format.raw/*37.13*/("""<form id="transfer-form" method="post" action=""""),_display_(/*37.61*/helpers/*37.68*/.url(repository)),format.raw/*37.84*/("""/settings/transfer" validate="true" autocomplete="off">
              <fieldset class="border-top form-group">
                <label class="strong">Transfer Ownership</label>
                <div>
                  Transfer this repository to another user or to group.
                  <div class="pull-right">
                    """),_display_(/*43.22*/gitbucket/*43.31*/.core.helper.html.account("newOwner", 200, true, true)),format.raw/*43.85*/("""
                    """),format.raw/*44.21*/("""<input type="submit" class="btn btn-danger" value="Transfer"/>
                    <div>
                      <span id="error-newOwner" class="error"></span>
                    </div>
                  </div>
                </div>
              </fieldset>
            </form>
          """)))} else {null} ),format.raw/*52.12*/("""
          """),_display_(if(context.settings.basicBehavior.repositoryOperation.delete || context.loginAccount.get.isAdmin)/*53.109*/{_display_(Seq[Any](format.raw/*53.110*/("""
            """),format.raw/*54.13*/("""<form id="delete-form" method="post" action=""""),_display_(/*54.59*/helpers/*54.66*/.url(repository)),format.raw/*54.82*/("""/settings/delete">
              <fieldset class="border-top form-group">
                <label class="strong">Delete repository</label>
                <div>
                  Permanently delete this repository. This cannot be undone.
                  <input type="submit" class="btn btn-danger pull-right" value="Delete this repository"/>
                </div>
              </fieldset>
            </form>
          """)))} else {null} ),format.raw/*63.12*/("""
        """),format.raw/*64.9*/("""</div>
      </div>
    """)))}),format.raw/*66.6*/("""
  """)))}),format.raw/*67.4*/("""
""")))}),format.raw/*68.2*/("""
"""),format.raw/*69.1*/("""<script>
$(function()"""),format.raw/*70.13*/("""{"""),format.raw/*70.14*/("""
  """),format.raw/*71.3*/("""$('#delete-form').submit(function()"""),format.raw/*71.38*/("""{"""),format.raw/*71.39*/("""
    """),format.raw/*72.5*/("""return confirm('Once you delete a repository, there is no going back.\nAre you sure?');
  """),format.raw/*73.3*/("""}"""),format.raw/*73.4*/(""");
  $('#rename-form').submit(function()"""),format.raw/*74.38*/("""{"""),format.raw/*74.39*/("""
    """),format.raw/*75.5*/("""if($('#rename-form').data('validated') === true)"""),format.raw/*75.53*/("""{"""),format.raw/*75.54*/("""
      """),format.raw/*76.7*/("""return confirm('Rename this repository as you entered. The current URL will be unavailable.\nAre you sure?');
    """),format.raw/*77.5*/("""}"""),format.raw/*77.6*/(""" """),format.raw/*77.7*/("""else """),format.raw/*77.12*/("""{"""),format.raw/*77.13*/("""
      """),format.raw/*78.7*/("""return true;
    """),format.raw/*79.5*/("""}"""),format.raw/*79.6*/("""
  """),format.raw/*80.3*/("""}"""),format.raw/*80.4*/(""");
  $('#transfer-form').submit(function()"""),format.raw/*81.40*/("""{"""),format.raw/*81.41*/("""
    """),format.raw/*82.5*/("""if($('#transfer-form').data('validated') === true)"""),format.raw/*82.55*/("""{"""),format.raw/*82.56*/("""
      """),format.raw/*83.7*/("""return confirm('Transfer to the repository owner you entered.\nAre you sure?');
    """),format.raw/*84.5*/("""}"""),format.raw/*84.6*/(""" """),format.raw/*84.7*/("""else """),format.raw/*84.12*/("""{"""),format.raw/*84.13*/("""
      """),format.raw/*85.7*/("""return true;
    """),format.raw/*86.5*/("""}"""),format.raw/*86.6*/("""
  """),format.raw/*87.3*/("""}"""),format.raw/*87.4*/(""");
  $('#gc-form').submit(function()"""),format.raw/*88.34*/("""{"""),format.raw/*88.35*/("""
    """),format.raw/*89.5*/("""return confirm('The garbage collection may take a long time.\nDo you want to execute it?');
  """),format.raw/*90.3*/("""}"""),format.raw/*90.4*/(""");
"""),format.raw/*91.1*/("""}"""),format.raw/*91.2*/(""");
</script>
"""))
      }
    }
  }

  def render(repository:gitbucket.core.service.RepositoryService.RepositoryInfo,info:Option[Any],context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(repository,info)(context)

  def f:((gitbucket.core.service.RepositoryService.RepositoryInfo,Option[Any]) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (repository,info) => (context) => apply(repository,info)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/settings/danger.scala.html
                  HASH: fa467bb84758c7c77a71ea61f42449f3c4cf202d
                  MATRIX: 680->1|894->144|957->180|974->189|1030->237|1068->238|1097->242|1114->251|1161->290|1199->291|1230->297|1247->306|1301->352|1339->353|1372->361|1389->370|1444->405|1477->412|1683->591|1699->598|1736->614|2251->1101|2291->1102|2332->1115|2405->1161|2421->1168|2458->1184|2983->1681|3003->1691|3030->1696|3422->2044|3561->2155|3601->2156|3642->2169|3717->2217|3733->2224|3770->2240|4131->2574|4149->2583|4224->2637|4273->2658|4608->2949|4745->3058|4785->3059|4826->3072|4899->3118|4915->3125|4952->3141|5419->3564|5455->3573|5510->3598|5544->3602|5576->3604|5604->3605|5653->3626|5682->3627|5712->3630|5775->3665|5804->3666|5836->3671|5953->3761|5981->3762|6049->3802|6078->3803|6110->3808|6186->3856|6215->3857|6249->3864|6390->3978|6418->3979|6446->3980|6479->3985|6508->3986|6542->3993|6586->4010|6614->4011|6644->4014|6672->4015|6742->4057|6771->4058|6803->4063|6881->4113|6910->4114|6944->4121|7055->4205|7083->4206|7111->4207|7144->4212|7173->4213|7207->4220|7251->4237|7279->4238|7309->4241|7337->4242|7401->4278|7430->4279|7462->4284|7583->4378|7611->4379|7641->4382|7669->4383
                  LINES: 14->1|17->2|20->3|20->3|20->3|20->3|21->4|21->4|21->4|21->4|22->5|22->5|22->5|22->5|23->6|23->6|23->6|24->7|27->10|27->10|27->10|36->19|36->19|37->20|37->20|37->20|37->20|43->26|43->26|43->26|52->35|53->36|53->36|54->37|54->37|54->37|54->37|60->43|60->43|60->43|61->44|69->52|70->53|70->53|71->54|71->54|71->54|71->54|80->63|81->64|83->66|84->67|85->68|86->69|87->70|87->70|88->71|88->71|88->71|89->72|90->73|90->73|91->74|91->74|92->75|92->75|92->75|93->76|94->77|94->77|94->77|94->77|94->77|95->78|96->79|96->79|97->80|97->80|98->81|98->81|99->82|99->82|99->82|100->83|101->84|101->84|101->84|101->84|101->84|102->85|103->86|103->86|104->87|104->87|105->88|105->88|106->89|107->90|107->90|108->91|108->91
                  -- GENERATED --
              */
          