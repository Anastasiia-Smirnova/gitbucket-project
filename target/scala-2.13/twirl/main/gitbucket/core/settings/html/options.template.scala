
package gitbucket.core.settings.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object options extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[gitbucket.core.service.RepositoryService.RepositoryInfo,Option[Any],gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(repository: gitbucket.core.service.RepositoryService.RepositoryInfo, info: Option[Any])(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*2.2*/import gitbucket.core.view.helpers


Seq[Any](_display_(/*3.2*/gitbucket/*3.11*/.core.html.main("Settings", Some(repository))/*3.56*/{_display_(Seq[Any](format.raw/*3.57*/("""
  """),_display_(/*4.4*/gitbucket/*4.13*/.core.html.menu("settings", repository)/*4.52*/{_display_(Seq[Any](format.raw/*4.53*/("""
    """),_display_(/*5.6*/gitbucket/*5.15*/.core.settings.html.menu("options", repository)/*5.62*/{_display_(Seq[Any](format.raw/*5.63*/("""
      """),_display_(/*6.8*/gitbucket/*6.17*/.core.helper.html.information(info)),format.raw/*6.52*/("""
      """),format.raw/*7.7*/("""<form id="form" method="post" action=""""),_display_(/*7.46*/helpers/*7.53*/.url(repository)),format.raw/*7.69*/("""/settings/options" validate="true" autocomplete="off">
        <div class="panel panel-default">
          <div class="panel-heading strong">Settings</div>
          <div class="panel-body">
            <fieldset class="form-group">
              <label for="description" class="strong">Description:</label>
              <input type="text" name="description" id="description" class="form-control" value=""""),_display_(/*13.99*/repository/*13.109*/.repository.description),format.raw/*13.132*/(""""/>
            </fieldset>
            <fieldset class="border-top">
              <label class="radio">
                <input type="radio" name="isPrivate" value="false"
                  """),_display_(if(!repository.repository.isPrivate              )/*18.70*/{_display_(Seq[Any](format.raw/*18.71*/(""" """),format.raw/*18.72*/("""checked  """)))} else {null} ),format.raw/*18.82*/("""
                  """),_display_(if(repository.repository.parentUserName.isDefined)/*19.70*/{_display_(Seq[Any](format.raw/*19.71*/(""" """),format.raw/*19.72*/("""disabled """)))} else {null} ),format.raw/*19.82*/("""
                """),format.raw/*20.17*/(""">
                <span class="strong"><i class="octicon octicon-repo"></i> Public</span><br>
                <div class="normal muted">
                  Anyone can see this repository. You choose who can commit.
                </div>
              </label>
              <label class="radio">
                <input type="radio" name="isPrivate" value="true"
                  """),_display_(if(repository.repository.isPrivate               )/*28.70*/{_display_(Seq[Any](format.raw/*28.71*/(""" """),format.raw/*28.72*/("""checked  """)))} else {null} ),format.raw/*28.82*/("""
                  """),_display_(if(repository.repository.parentUserName.isDefined)/*29.70*/{_display_(Seq[Any](format.raw/*29.71*/(""" """),format.raw/*29.72*/("""disabled """)))} else {null} ),format.raw/*29.82*/("""
                """),format.raw/*30.17*/(""">
                <span class="strong"><i class="octicon octicon-lock"></i> Private</span><br>
                <div class="normal muted">
                  You choose who can see and commit to this repository.
                </div>
              </label>
              <label class="checkbox" for="allowFork">
                <input type="checkbox" id="allowFork" name="allowFork""""),_display_(if(repository.repository.options.allowFork)/*37.115*/{_display_(Seq[Any](format.raw/*37.116*/(""" """),format.raw/*37.117*/("""checked""")))} else {null} ),format.raw/*37.125*/("""/>
                Forks<br>
                <div class="normal muted">
                  Allow users who can access this repository to fork it.
                </div>
              </label>
              <label class="checkbox" for="safeMode">
                <input type="checkbox" id="safeMode" name="safeMode""""),_display_(if(repository.repository.options.safeMode)/*44.112*/{_display_(Seq[Any](format.raw/*44.113*/(""" """),format.raw/*44.114*/("""checked""")))} else {null} ),format.raw/*44.122*/("""/>
                XSS protection<br>
                <div class="normal muted">
                  Render any images in the repository viewer. Don't disable this option in the public environment.
                </div>
              </label>
            </fieldset>
          </div>
        </div>
        <div class="panel panel-default">
          <div class="panel-heading strong">Issues and Pull Requests</div>
          <div class="panel-body">
            <fieldset class="form-group">
              <div class="radio">
                <label>
                  <input type="radio" name="issuesOption" value="DISABLE" """),_display_(if(repository.repository.options.issuesOption == "DISABLE")/*59.135*/{_display_(Seq[Any](format.raw/*59.136*/(""" """),format.raw/*59.137*/("""checked""")))} else {null} ),format.raw/*59.145*/("""> Disable issue tracking and pull requests
                </label>
              </div>
              <div class="radio">
                <label>
                  <input type="radio" name="issuesOption" value="PRIVATE" """),_display_(if(repository.repository.options.issuesOption == "PRIVATE")/*64.135*/{_display_(Seq[Any](format.raw/*64.136*/(""" """),format.raw/*64.137*/("""checked""")))} else {null} ),format.raw/*64.145*/("""> Developers can view, create, and comment on issues and pull requests
                </label>
              </div>
              <div class="radio">
                <label>
                  <input type="radio" name="issuesOption" value="PUBLIC" """),_display_(if(repository.repository.options.issuesOption == "PUBLIC")/*69.133*/{_display_(Seq[Any](format.raw/*69.134*/(""" """),format.raw/*69.135*/("""checked""")))} else {null} ),format.raw/*69.143*/("""> Developers and guests can view, create, and comment on issues and pull requests
                </label>
              </div>
              <div class="radio for-public-repo">
                <label>
                  <input type="radio" name="issuesOption" value="ALL" """),_display_(if(repository.repository.options.issuesOption == "ALL")/*74.127*/{_display_(Seq[Any](format.raw/*74.128*/(""" """),format.raw/*74.129*/("""checked""")))} else {null} ),format.raw/*74.137*/("""> All users can view, create, and comment on issues and pull requests
                </label>
              </div>
              <label for="externalIssuesUrl" class="strong">External URL:
                <span class="normal muted">(Fill if you use an external issue tracking system for this project)</span>
              </label>
              <input type="text" class="form-control" id="externalIssuesUrl" name="externalIssuesUrl" value=""""),_display_(/*80.111*/repository/*80.121*/.repository.options.externalIssuesUrl),format.raw/*80.158*/(""""/>
            </fieldset>
          </div>
        </div>
        <div class="panel panel-default">
          <div class="panel-heading strong">Wiki</div>
          <div class="panel-body">
            <fieldset class="form-group">
              <div class="radio">
                <label>
                  <input type="radio" name="wikiOption" value="DISABLE" """),_display_(if(repository.repository.options.wikiOption == "DISABLE")/*90.131*/{_display_(Seq[Any](format.raw/*90.132*/(""" """),format.raw/*90.133*/("""checked""")))} else {null} ),format.raw/*90.141*/("""> Disable wiki
                </label>
              </div>
              <div class="radio">
                <label>
                  <input type="radio" name="wikiOption" value="PRIVATE" """),_display_(if(repository.repository.options.wikiOption == "PRIVATE")/*95.131*/{_display_(Seq[Any](format.raw/*95.132*/(""" """),format.raw/*95.133*/("""checked""")))} else {null} ),format.raw/*95.141*/("""> Developers can view, create, and edit wiki pages
                </label>
              </div>
              <div class="radio">
                <label>
                  <input type="radio" name="wikiOption" value="PUBLIC" """),_display_(if(repository.repository.options.wikiOption == "PUBLIC")/*100.129*/{_display_(Seq[Any](format.raw/*100.130*/(""" """),format.raw/*100.131*/("""checked""")))} else {null} ),format.raw/*100.139*/("""> Developers and guests can view, create, and edit wiki pages
                </label>
              </div>
              <div class="radio for-public-repo">
                <label>
                  <input type="radio" name="wikiOption" value="ALL" """),_display_(if(repository.repository.options.wikiOption == "ALL")/*105.123*/{_display_(Seq[Any](format.raw/*105.124*/(""" """),format.raw/*105.125*/("""checked""")))} else {null} ),format.raw/*105.133*/("""> All users can view, create, and edit wiki pages
                </label>
              </div>
              <label for="externalWikiUrl" class="strong">External URL:
                <span class="normal muted">(Fill if you use an external wiki for this project)</span>
              </label>
              <input type="text" class="form-control" id="externalWikiUrl" name="externalWikiUrl" value=""""),_display_(/*111.107*/repository/*111.117*/.repository.options.externalWikiUrl),format.raw/*111.152*/(""""/>
            </fieldset>
          </div>
        </div>
        <div class="panel panel-default">
          <div class="panel-heading strong">Merge strategy</div>
          <div class="panel-body">
            Select pull request merge strategies which are available in this repository. At least one option must be enabled.
            <fieldset class="form-group">
              """),_display_(/*120.16*/defining(repository.repository.options.mergeOptions.split(","))/*120.79*/{ mergeOptions =>_display_(Seq[Any](format.raw/*120.96*/("""
                """),format.raw/*121.17*/("""<div class="checkbox">
                  <label for="mergeOptions_MergeCommit">
                    <input type="checkbox" name="mergeOptions" id="mergeOptions_MergeCommit" value="merge-commit" """),_display_(if(mergeOptions.contains("merge-commit"))/*123.157*/{_display_(Seq[Any](format.raw/*123.158*/("""checked""")))} else {null} ),format.raw/*123.166*/(""">
                  <span class="strong">Merge commit</span>
                  <div class="normal muted">Commits will be added to the base branch via a merge commit.</div>
                  </label>
                </div>
                <div class="checkbox">
                  <label for="mergeOptions_Squash">
                    <input type="checkbox" name="mergeOptions" id="mergeOptions_Squash" value="squash" """),_display_(if(mergeOptions.contains("squash"))/*130.140*/{_display_(Seq[Any](format.raw/*130.141*/("""checked""")))} else {null} ),format.raw/*130.149*/(""">
                    <span class="strong">Squash</span>
                    <div class="normal muted">Commits will be combined into one commit in the base branch.</div>
                  </label>
                </div>
                <div class="checkbox">
                  <label for="mergeOptions_Rebase">
                    <input type="checkbox" name="mergeOptions" id="mergeOptions_Rebase" value="rebase" """),_display_(if(mergeOptions.contains("rebase"))/*137.140*/{_display_(Seq[Any](format.raw/*137.141*/("""checked""")))} else {null} ),format.raw/*137.149*/(""">
                    <span class="strong">Rebase</span>
                    <div class="normal muted">Commits will be rebased and added to the base branch.</div>
                  </label>
                </div>
                <span id="error-mergeOptions" class="error"></span>
              """)))}),format.raw/*143.16*/("""
              """),format.raw/*144.15*/("""<fieldset class="form-group">
                <label for="defaultMergeOption">Default merge strategy</label>
                """),_display_(/*146.18*/defining(repository.repository.options.defaultMergeOption)/*146.76*/ { defaultMergeOption =>_display_(Seq[Any](format.raw/*146.100*/("""
                  """),format.raw/*147.19*/("""<select name="defaultMergeOption" id="defaultMergeOption">
                    <option value="merge-commit" """),_display_(if(defaultMergeOption == "merge-commit")/*148.91*/{_display_(Seq[Any](format.raw/*148.92*/("""selected""")))} else {null} ),format.raw/*148.101*/(""">Merge commit</option>
                    <option value="squash" """),_display_(if(defaultMergeOption == "squash")/*149.79*/{_display_(Seq[Any](format.raw/*149.80*/("""selected""")))} else {null} ),format.raw/*149.89*/(""">Squash</option>
                    <option value="rebase" """),_display_(if(defaultMergeOption == "rebase")/*150.79*/{_display_(Seq[Any](format.raw/*150.80*/("""selected""")))} else {null} ),format.raw/*150.89*/(""">Rebase</option>
                  </select>
                """)))}),format.raw/*152.18*/("""
                """),format.raw/*153.17*/("""<span id="error-defaultMergeOption" class="error"></span>
              </fieldset>
            </fieldset>
          </div>
        </div>
        <div class="align-right" style="margin-top: 20px;">
          <input type="submit" class="btn btn-success" value="Apply changes"/>
        </div>
      </form>
    """)))}),format.raw/*162.6*/("""
  """)))}),format.raw/*163.4*/("""
""")))}),format.raw/*164.2*/("""
"""),format.raw/*165.1*/("""<script>
$(function()"""),format.raw/*166.13*/("""{"""),format.raw/*166.14*/("""
  """),format.raw/*167.3*/("""updateFeatures();
  $('input[name=isPrivate], input[name=issuesOption], input[name=wikiOption]').click(function()"""),format.raw/*168.96*/("""{"""),format.raw/*168.97*/("""
    """),format.raw/*169.5*/("""updateFeatures();
  """),format.raw/*170.3*/("""}"""),format.raw/*170.4*/(""");
"""),format.raw/*171.1*/("""}"""),format.raw/*171.2*/(""");

function updateFeatures() """),format.raw/*173.27*/("""{"""),format.raw/*173.28*/("""
  """),format.raw/*174.3*/("""if($('input[name=isPrivate]:checked').val() == 'false')"""),format.raw/*174.58*/("""{"""),format.raw/*174.59*/("""
    """),format.raw/*175.5*/("""$('.for-public-repo').show();
  """),format.raw/*176.3*/("""}"""),format.raw/*176.4*/(""" """),format.raw/*176.5*/("""else """),format.raw/*176.10*/("""{"""),format.raw/*176.11*/("""
    """),format.raw/*177.5*/("""if($('input[name=issuesOption]:checked').val() == 'ALL')"""),format.raw/*177.61*/("""{"""),format.raw/*177.62*/("""
      """),format.raw/*178.7*/("""$('input[name=issuesOption][value=PUBLIC]').prop('checked', true);
    """),format.raw/*179.5*/("""}"""),format.raw/*179.6*/("""
    """),format.raw/*180.5*/("""if($('input[name=wikiOption]:checked').val() == 'ALL')"""),format.raw/*180.59*/("""{"""),format.raw/*180.60*/("""
      """),format.raw/*181.7*/("""$('input[name=wikiOption][value=PUBLIC]').prop('checked', true);
    """),format.raw/*182.5*/("""}"""),format.raw/*182.6*/("""
    """),format.raw/*183.5*/("""$('.for-public-repo').hide();
  """),format.raw/*184.3*/("""}"""),format.raw/*184.4*/("""

  """),format.raw/*186.3*/("""$('#externalIssuesUrl').prop('disabled', $('input[name=issuesOption]:checked').val() != 'DISABLE');
  $('#externalWikiUrl').prop('disabled', $('input[name=wikiOption]:checked').val() != 'DISABLE');
"""),format.raw/*188.1*/("""}"""),format.raw/*188.2*/("""
"""),format.raw/*189.1*/("""</script>
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
                  SOURCE: src/main/twirl/gitbucket/core/settings/options.scala.html
                  HASH: 0514866f6250ec9e8588a336dff0e4b2190f747b
                  MATRIX: 681->1|895->144|958->180|975->189|1028->234|1066->235|1095->239|1112->248|1159->287|1197->288|1228->294|1245->303|1300->350|1338->351|1371->359|1388->368|1443->403|1476->410|1541->449|1556->456|1592->472|2025->878|2045->888|2090->911|2359->1153|2398->1154|2427->1155|2481->1165|2578->1235|2617->1236|2646->1237|2700->1247|2745->1264|3203->1695|3242->1696|3271->1697|3325->1707|3422->1777|3461->1778|3490->1779|3544->1789|3589->1806|4042->2231|4082->2232|4112->2233|4165->2241|4549->2597|4589->2598|4619->2599|4672->2607|5384->3291|5424->3292|5454->3293|5507->3301|5816->3582|5856->3583|5886->3584|5939->3592|6274->3899|6314->3900|6344->3901|6397->3909|6753->4237|6793->4238|6823->4239|6876->4247|7346->4689|7366->4699|7425->4736|7875->5158|7915->5159|7945->5160|7998->5168|8275->5417|8315->5418|8345->5419|8398->5427|8710->5710|8751->5711|8782->5712|8836->5720|9169->6024|9210->6025|9241->6026|9295->6034|9723->6433|9744->6443|9802->6478|10215->6863|10288->6926|10344->6943|10390->6960|10655->7196|10696->7197|10750->7205|11231->7657|11272->7658|11326->7666|11805->8116|11846->8117|11900->8125|12228->8421|12272->8436|12426->8562|12494->8620|12558->8644|12606->8663|12783->8812|12823->8813|12878->8822|13007->8923|13047->8924|13101->8933|13224->9028|13264->9029|13318->9038|13412->9100|13458->9117|13802->9430|13837->9434|13870->9436|13899->9437|13949->9458|13979->9459|14010->9462|14152->9575|14182->9576|14215->9581|14263->9601|14292->9602|14323->9605|14352->9606|14411->9636|14441->9637|14472->9640|14556->9695|14586->9696|14619->9701|14679->9733|14708->9734|14737->9735|14771->9740|14801->9741|14834->9746|14919->9802|14949->9803|14984->9810|15083->9881|15112->9882|15145->9887|15228->9941|15258->9942|15293->9949|15390->10018|15419->10019|15452->10024|15512->10056|15541->10057|15573->10061|15799->10259|15828->10260|15857->10261
                  LINES: 14->1|17->2|20->3|20->3|20->3|20->3|21->4|21->4|21->4|21->4|22->5|22->5|22->5|22->5|23->6|23->6|23->6|24->7|24->7|24->7|24->7|30->13|30->13|30->13|35->18|35->18|35->18|35->18|36->19|36->19|36->19|36->19|37->20|45->28|45->28|45->28|45->28|46->29|46->29|46->29|46->29|47->30|54->37|54->37|54->37|54->37|61->44|61->44|61->44|61->44|76->59|76->59|76->59|76->59|81->64|81->64|81->64|81->64|86->69|86->69|86->69|86->69|91->74|91->74|91->74|91->74|97->80|97->80|97->80|107->90|107->90|107->90|107->90|112->95|112->95|112->95|112->95|117->100|117->100|117->100|117->100|122->105|122->105|122->105|122->105|128->111|128->111|128->111|137->120|137->120|137->120|138->121|140->123|140->123|140->123|147->130|147->130|147->130|154->137|154->137|154->137|160->143|161->144|163->146|163->146|163->146|164->147|165->148|165->148|165->148|166->149|166->149|166->149|167->150|167->150|167->150|169->152|170->153|179->162|180->163|181->164|182->165|183->166|183->166|184->167|185->168|185->168|186->169|187->170|187->170|188->171|188->171|190->173|190->173|191->174|191->174|191->174|192->175|193->176|193->176|193->176|193->176|193->176|194->177|194->177|194->177|195->178|196->179|196->179|197->180|197->180|197->180|198->181|199->182|199->182|200->183|201->184|201->184|203->186|205->188|205->188|206->189
                  -- GENERATED --
              */
          