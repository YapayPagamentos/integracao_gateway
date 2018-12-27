require "bundler/setup"
require "yapay_gw"
require_relative '../lib/yapay_gw/builder/oneclick_builder'
require_relative '../lib/yapay_gw/models/oneclick_register_data'
require_relative '../lib/yapay_gw/builder/recurring_payment_builder'
require_relative '../lib/yapay_gw/models/recurring_payment'
require_relative '../lib/yapay_gw/models/recurring_charging_data'
require_relative '../lib/yapay_gw/models/transaction_card_data'
require_relative '../lib/yapay_gw/models/transaction_phone_data'
require_relative '../lib/yapay_gw/models/recurring_shipping_data'
require_relative '../lib/yapay_gw/builder/transaction_builder'
require_relative '../lib/yapay_gw/models/transaction'
require_relative '../lib/yapay_gw/models/transaction_data'
require_relative '../lib/yapay_gw/models/transaction_extra_field'
require_relative '../lib/yapay_gw/models/transaction_charging_data'
require_relative '../lib/yapay_gw/communication/base_url'

RSpec.configure do |config|

  config.example_status_persistence_file_path = ".rspec_status"

  config.disable_monkey_patching!

  config.expect_with :rspec do |c|
    c.syntax = :expect
  end
end
