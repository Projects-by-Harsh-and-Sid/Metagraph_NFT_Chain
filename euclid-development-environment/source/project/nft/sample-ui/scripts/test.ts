import { Command } from 'commander';
import boxen from 'boxen';

import 'dotenv/config';
import { dag4 } from '@stardust-collective/dag4';


import { EnvironmentContext } from '../src/lib/index.ts';

console.log(EnvironmentContext.metagraphL1DataUrl + '/data');